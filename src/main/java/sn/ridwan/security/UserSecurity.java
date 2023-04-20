package sn.ridwan.security;

import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;

import static io.jsonwebtoken.SignatureAlgorithm.HS384;

@ApplicationScoped
@Path("/security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserSecurity  {
    private static final int API_KEY = 2;
    private static final String API_SECRET= "ss";

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
            System.out.println("LOGIN utilise : "+login);
            boolean authenticated = authentification(login, password);
            return Response.ok(authenticated).build();
       /* if (authenticated) {
            String token = generateToken(id);
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }*/

       /* }else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }*/

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
    private String generateToken(Long id) {
        // Generate a secure token and store it in the database
         return null;
    }
   /* private String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
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
    }*/
    public Key generateSecretKey(String keyString) {
        return new SecretKeySpec(keyString.getBytes(),0,keyString.getBytes().length,"AES");
    }
}
