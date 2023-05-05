package sn.ridwan.security.service_security_impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.DatatypeConverter;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.service_security_interfaces.UserSecurityInterfaces;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@ApplicationScoped
public class UserSecurityImpl implements UserSecurityInterfaces {

    // @Context
    //static Logger logger1= Logger.getLogger(Adherent.class);
    //static Logger logger2= Logger.getLogger(Agent.class);
    static final String SECRET_KEY="odKAmV6AbsoWsyL3thUoYVDEJAsQl8RrH+JuQ9HWUnDLunDdLEM6oNl15XP1xLOHz3bEq1rvATiQmAByKNOiVujd1gsq7JxfQYDdHRzDhZZrUstnetvGTDBtMHmhzbBX";

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Override
    public String getUserByLoginByRole(String login) {
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT us FROM User us WHERE  us.userIdd=:login", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        return userByLogin.getRole();
    }
    @Override
    public long getUserByLoginById(String login) {
        if (login.contains("MAT-") || login.contains("@ridwan")){
            TypedQuery<Agent> typedQueryGetLogin = em.createQuery("SELECT user FROM Agent user WHERE (user.matricule=:login OR user.ag_email=:login)", Agent.class);
            typedQueryGetLogin.setParameter("login", login);
            Agent userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getId();
        }
        if (login.contains("RIDCA-") || login.contains("@gmail")){
            TypedQuery<Adherent> typedQueryGetLogin = em.createQuery("SELECT user FROM Adherent user WHERE (user.IpmID=:login OR user.ad_email=:login)", Adherent.class);
            typedQueryGetLogin.setParameter("login", login);
            Adherent userByLogin = typedQueryGetLogin.getSingleResult();
            //System.out.println("################################### userByLogin.getId() :"+userByLogin.getId()+" ########################################");
            return userByLogin.getId();
        }

        //System.out.println("################################### Current UserIdd Login By Telephone:"+userIDLogin+" ########################################");
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE  user.tel=:login", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        //System.out.println("################################### getPassword By Login with Telephone :"+userByLogin.getPassword()+" ########################################");
        return userByLogin.getId();

    }

    @Override
    public String getUserByLoginAgent(String login){
        TypedQuery<Agent> typedQueryGetLogin = em.createQuery("SELECT ag FROM Agent ag WHERE ag.matricule=:login", Agent.class);
        typedQueryGetLogin.setParameter("login", login);
        Agent userByLogin = typedQueryGetLogin.getSingleResult();
        return userByLogin.getRole();
    }

    @Override
    public String hashPass(String login){
        //String userIDLogin =getLoginType(login);
        //System.out.println("################################### Current UserIdd in hash():"+login+" ########################################");
        if(login.contains("MAT-") || login.contains("@ridwan")){
            //System.out.println("################################### Current UserIdd content Agent):"+login+" ########################################");
            TypedQuery<Agent> typedQueryGetLogin = em.createQuery("SELECT user FROM Agent user WHERE  (user.matricule=:login OR user.ag_email=:login)", Agent.class);
            typedQueryGetLogin.setParameter("login", login);
            Agent userByLogin = typedQueryGetLogin.getSingleResult();
            //System.out.println("################################### getPasswordAgent() :"+userByLogin.getPassword()+" ########################################");
            return userByLogin.getPassword();
        }
        if(login.contains("RIDCA-") || login.contains("@gmail")){
           // System.out.println("################################### Current UserIdd content(Adherent-):"+login+" ########################################");
            TypedQuery<Adherent> typedQueryGetLogin = em.createQuery("SELECT user FROM Adherent user WHERE  (user.IpmID=:login OR user.ad_email=:login) ", Adherent.class);
            typedQueryGetLogin.setParameter("login", login);
            Adherent userByLogin = typedQueryGetLogin.getSingleResult();
            //System.out.println("################################### getPasswordAdherent() :"+userByLogin.getPassword()+" ########################################");
            return userByLogin.getPassword();
        }
        //System.out.println("################################### Current UserIdd Login By Telephone:"+login+" ########################################");
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE  user.tel=:login", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
        //System.out.println("################################### getPassword By Login with Telephone :"+userByLogin.getPassword()+" ########################################");
        return userByLogin.getPassword();

    }

    @Override
    public BCrypt.Result verifyPassword(String plainPassword,String bcryptHashString){
        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), bcryptHashString);
        return result;
    }
    @Override
    public boolean authentification(String login,String passworde) {
       //String userRole = getUserByLoginByRole(login);
        //String userRole = getLoginType(login);
       // System.out.println("################################### login :"+login+" ########################################");

        String hash = hashPass(login);
        //System.out.println("################################### hassPassword :"+hash+" ########################################");

        BCrypt.Result verifyPassword = verifyPassword(passworde,hash);
        if(verifyPassword.verified){
            String password = hash;
            if(login.contains("MAT-") || login.contains("@ridwan")){
                TypedQuery<Agent> typedQueryLogin = em.createQuery("SELECT user FROM Agent user WHERE (user.matricule=:login OR user.ag_email=:login)  AND user.isEtat=true AND user.password=:password", Agent.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                Agent userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
            if(login.contains("RIDCA-") || login.contains("@gmail")) {
                TypedQuery<Adherent> typedQueryLogin = em.createQuery("SELECT user FROM Adherent user WHERE (user.IpmID=:login OR user.ad_email=:login) AND user.isEtat=true AND user.password=:password", Adherent.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                Adherent userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
            if(login.contains("+221_")){
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE  user.tel=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
               // System.out.println("################################### getType By Login with Telephone :" + userByLogin.getPassword() + " ########################################");
                return true;
            }

        }
        try{
            return true;
        } catch(jakarta.persistence.NoResultException e) {
            return false;
        }
    }

    @Override
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
