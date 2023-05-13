package sn.ridwan.security.service_security_interfaces;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.ejb.Local;
import sn.ridwan.ipm.model.User;


@Local
public interface UserSecurityInterfaces {
    //public String getUserByLoginByRole(String login);
    public User getUserByLoginById(String login);
   // public String getUserByLoginAgent(String login);
    public User hashPass(String login);
    public BCrypt.Result verifyPassword(String plainPassword, String bcryptHashString);
    public boolean authentification(String login,String passworde);
    public String createJWT(long id, long ttlMillis);
}
