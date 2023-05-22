package sn.ridwan.security.service_security_interfaces;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.ejb.Local;
import jakarta.persistence.Query;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.DatatypeConverter;
import sn.ridwan.ipm.model.User;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;


@Local
public interface UserSecurityInterfaces {

    //public User getUserByLoginBy(String login);
   // public String getUserByLoginAgent(String login);
    //public String hashPass(String login);
    //public BCrypt.Result verifyPassword(String plainPassword, String bcryptHashString);
    //public String authentification(String login, String passworde);
    //public String createJWT(long id, long ttlMillis);
   // public User getUser(String login) ;


    //public Long getUserByLoginById(String login) ;

}
