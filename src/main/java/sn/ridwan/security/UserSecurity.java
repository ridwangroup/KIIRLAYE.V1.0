package sn.ridwan.security;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.DatatypeConverter;
import org.jboss.resteasy.logging.Logger;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.User;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.SQLException;
import java.util.Date;



@ApplicationScoped
@Path("/security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserSecurity  {
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
        System.out.println("LOGIN utilise : \n"+login+"\n"+user.getIpmId()+"\n"+user.getNumTelephone());
        String token = createJWT(login,user.getIpmId(),user.getNumTelephone(),60000);
        return Response.ok("{\"token\": \"" + token + "\"}").build();
    }

    public boolean authentification(String login,String password) {
        TypedQuery<User> typedQueryEmail = em.createQuery("SELECT u FROM User u WHERE (u.email=:login OR  u.ipmId=:login OR u.numTelephone=:login) AND u.password=:password", User.class);
        typedQueryEmail.setParameter("login", login);
        typedQueryEmail.setParameter("password", password);
        try{
            User u = typedQueryEmail.getSingleResult();
            System.out.println("getSingleResult : \n"+"id -> "+u.getId()+"\nPrenom -> "+u.getPrenom()
                    +"\nNom -> "+u.getNom()+"\nRole -> "+u.getRole()+"\n");
            return true;
        }catch(jakarta.persistence.NoResultException e) {
            return false;
        }
    }

    public String createJWT(String id, String issuer, String subject, long ttlMillis) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
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
