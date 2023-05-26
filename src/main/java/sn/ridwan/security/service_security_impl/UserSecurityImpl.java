package sn.ridwan.security.service_security_impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.xml.bind.DatatypeConverter;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.connexion.MyEmail;
import sn.ridwan.security.connexion.MyPhone;
import sn.ridwan.security.connexion.MyUserId;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

import static sn.ridwan.security.helpers.ValidatorHelper.*;

@RequestScoped
public class UserSecurityImpl {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    MyPhone tel;
    @Inject
    MyEmail email;
    @Inject
    MyUserId userId;

    public String returnId(String username,String pwd) {
        String type = getLoginType(username);
        if(type.equals("email")){
            String id =email.authentificationEmail(username, pwd);
            return id;
        }
        if(type.equals("userId")){
            String id =userId.authentificationUserId(username, pwd);
            return id;
        }
        if(type.equals("telephone")){
            String id =tel.authentificationPhone(username, pwd);
            return id;
        }

        return null;
    }

    public boolean returnFirstConnexion(String login) {
        String type = getLoginType(login);
        if(type.equals("email")){
            TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.email=:login AND user.isEtat=true", User.class);
            typedQueryLogin.setParameter("login", login);
            User user = typedQueryLogin.getSingleResult();
            return user.isFirstConnection();
        }
        if(type.equals("userId")){
            TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.userIdd=:login AND user.isEtat=true", User.class);
            typedQueryLogin.setParameter("login", login);
            User user = typedQueryLogin.getSingleResult();
            return user.isFirstConnection();
        }
       // if(type.equals("telephone")){
            TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.tel=:login AND user.isEtat=true", User.class);
            typedQueryLogin.setParameter("login", login);
            User user = typedQueryLogin.getSingleResult();
            return user.isFirstConnection();

    }
    public String authentification(String username,String pwd) {
        String type = getLoginType(username);
        if(type.equals("email")){
            String id =email.authentificationEmail(username, pwd);
          return createJWT(Long.parseLong(id),milliSecond());
        }
       if(type.equals("userId")){
            String id =userId.authentificationUserId(username, pwd);
            return createJWT(Long.parseLong(id),milliSecond());
        }
        if(type.equals("telephone")){
            String id =tel.authentificationPhone(username, pwd);
            return createJWT(Long.parseLong(id),milliSecond());
        }

        return null;
    }

   public String returnLoginType(String login){
       String loginType = getLoginType(login);
        if(loginType!=null){
            //String tmpQuery="Select user From User user Where user.isEtat=:true";
            if(loginType == "email"){

                return "email";
            }
            if(loginType == "userId"){
                return "userId";
            }
            if(loginType == "telephone"){
                return "telephone";
            }
        }



        return null;
    }


    public String createJWT(long id, long ttlMillis) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecretKey());
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
