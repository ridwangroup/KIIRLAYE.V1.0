package sn.ridwan.security.service_security_impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.xml.bind.DatatypeConverter;
import sn.ridwan.security.connexion.MyEmail;
import sn.ridwan.security.connexion.MyPhone;
import sn.ridwan.security.connexion.MyUserId;
import sn.ridwan.security.helpers.ValidatorHelper;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@RequestScoped
public class UserSecurityImpl {
    static final String SECRET_KEY= ValidatorHelper.SecretKey();

    @Inject
    MyPhone tel;
    @Inject
    MyEmail email;
    @Inject
    MyUserId userId;


    public String authentification(String username,String pwd) {
        if(username.contains("@")){
            String id =email.authentificationEmail(username, pwd);
           return createJWT(Long.parseLong(id),60000);
        }
       if(username.contains("MAT") || (username.contains("RIDCA"))){
            String id =userId.authentificationUserId(username, pwd);
            return createJWT(Long.parseLong(id),60000);
        }
        if(username.startsWith("70") || username.startsWith("75") || username.startsWith("76") || username.startsWith("77") || username.startsWith("78")){
            String id =tel.authentificationPhone(username, pwd);
            return createJWT(Long.parseLong(id),60000);
        }

        return null;
    }

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
