package sn.ridwan.security;


import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.DatatypeConverter;
import org.jboss.resteasy.logging.Logger;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.User;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;


@ApplicationScoped
@Path("/security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserSecurity  {
    @Context
    static Logger logger1= Logger.getLogger(Adherent.class);
    static Logger logger2= Logger.getLogger(Agent.class);

    static final String SECRET_KEY="odKAmV6AbsoWsyL3thUoYVDEJAsQl8RrH+JuQ9HWUnDLunDdLEM6oNl15XP1xLOHz3bEq1rvATiQmAByKNOiVujd1gsq7JxfQYDdHRzDhZZrUstnetvGTDBtMHmhzbBX";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;


    @POST
    @Path("/add/adherent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAdherent(Adherent user) {
        logger1.info("Adding Adherent...");
        em.persist(user);
    }
    @POST
    @Path("/add/agent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAgent(Agent user) {
        logger2.info("Adding Agent...");
        em.persist(user);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
            //Cette fonction return True si la connection a reussie | sinon False
            boolean isAuthenticated = authentification(login, password);
        if (!isAuthenticated) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        long  userId = getUserByLoginById(login);
        String token = createJWT(userId,60000);
        return Response.ok("{\"token\": \"" + token + "\"}").build();
    }


    public String getUserByLoginByRole(String login){
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT us FROM User us WHERE (us.email=:login OR  us.userIdd=:login OR us.numTelephone=:login)", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        return userByLogin.getRole();
    }
    public long getUserByLoginById(String login){
        //System.out.println("#######Login utilise : "+login);
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT us FROM User us WHERE (us.email=:login OR  us.userIdd=:login OR us.numTelephone=:login)", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        //System.out.println("######userByRole : "+userByLogin.getRole());
        return userByLogin.getId();
    }
    public String getUserByLoginAgent(String login){
        TypedQuery<Agent> typedQueryGetLogin = em.createQuery("SELECT ag FROM Agent ag WHERE ag.matricule=:login", Agent.class);
        typedQueryGetLogin.setParameter("login", login);
        Agent userByLogin = typedQueryGetLogin.getSingleResult();
        return userByLogin.getRole();
    }
    public String hashPass(String login){
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT us FROM User us WHERE (us.email=:login OR  us.userIdd=:login OR us.numTelephone=:login)", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        return userByLogin.getPassword();
    }
    public BCrypt.Result verifyPassword(String plainPassword,String bcryptHashString){
        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), bcryptHashString);
        return result;
    }
    public boolean authentification(String login,String passworde) {
        String userRole = getUserByLoginByRole(login);
        String hash = hashPass(login);
        BCrypt.Result verifyPassword = verifyPassword(passworde,hash);
        if(verifyPassword.verified){
            String password = hash;
            if(!userRole.equals("ROLE_AGENT")){
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT u FROM User u WHERE (u.email=:login OR  u.userIdd=:login OR u.numTelephone=:login) AND u.isEtat=true AND u.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User u = typedQueryLogin.getSingleResult();
                return true;
            }
            TypedQuery<User> typedQueryLogin = em.createQuery("SELECT u FROM User u WHERE  u.userIdd=:login AND u.isEtat=true AND u.password=:password", User.class);
            typedQueryLogin.setParameter("login", login);
            typedQueryLogin.setParameter("password", password);
            User u = typedQueryLogin.getSingleResult();
        }
        try{
            return true;
        } catch(jakarta.persistence.NoResultException e) {
        return false;
        }
    }
    //public String createJWT(long id, String issuer, String subject, long ttlMillis) {
    public String createJWT(long id, long ttlMillis) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
         //.setSubject(subject)
         //.setIssuer(issuer)
        JwtBuilder builder = Jwts.builder().setId(String.valueOf(id))
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey );

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

}
