package sn.ridwan.security.service_security_impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.xml.bind.DatatypeConverter;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.service_security_interfaces.UserSecurityInterfaces;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@ApplicationScoped
public class UserSecurityImpl implements UserSecurityInterfaces {
    static final String SECRET_KEY="odKAmV6AbsoWsyL3thUoYVDEJAsQl8RrH+JuQ9HWUnDLunDdLEM6oNl15XP1xLOHz3bEq1rvATiQmAByKNOiVujd1gsq7JxfQYDdHRzDhZZrUstnetvGTDBtMHmhzbBX";

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @Override
    public long getUserByLoginById(String login) {
        if( login.contains("@ridwan")){
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.email=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getId();
        }
        if(login.contains("MAT-")){
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getId();
        }
        if(login.contains("@gmail")) {
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE  user.email=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getId();
        }
        if(login.contains("RIDCA-")) {
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getId();
        }
        TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.tel=:login", User.class);
        typedQueryGetLogin.setParameter("login", login);
        User userByLogin = typedQueryGetLogin.getSingleResult();
           return userByLogin.getId();
    }

    @Override
    public String hashPass(String login){
         if( login.contains("@ridwan")){
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.email=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getPassword();
        }
        if(login.contains("MAT-")){
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getPassword();
        }
        if(login.contains("@gmail")) {
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE  user.email=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getPassword();
        }
        if(login.contains("RIDCA-")) {
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getPassword();
        }
            TypedQuery<User> typedQueryGetLogin = em.createQuery("SELECT user FROM User user WHERE user.tel=:login", User.class);
            typedQueryGetLogin.setParameter("login", login);
            User userByLogin = typedQueryGetLogin.getSingleResult();
            return userByLogin.getPassword();

    }

    @Override
    public BCrypt.Result verifyPassword(String plainPassword,String bcryptHashString){
        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), bcryptHashString);
        return result;
    }
    @Override
    public boolean authentification(String login,String passworde) {
        String hash = hashPass(login);

        BCrypt.Result verifyPassword = verifyPassword(passworde,hash);
        boolean verifyPassTrue =verifyPassword.verified ;
        //if(verifyPassword.verified){
            String password = hash;
            if(login.contains("MAT-") && verifyPassTrue){
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
            if(login.contains("@ridwan") && verifyPassTrue){
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.email=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
            if(login.contains("RIDCA-") && verifyPassTrue) {
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
            if(login.contains("@gmail") && verifyPassTrue) {
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE  user.email=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
                return true;
            }
                TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE  user.tel=:login AND user.isEtat=true AND user.password=:password", User.class);
                typedQueryLogin.setParameter("login", login);
                typedQueryLogin.setParameter("password", password);
                User userByLogin = typedQueryLogin.getSingleResult();
                return true;

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
