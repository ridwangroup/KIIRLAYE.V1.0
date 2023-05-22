package sn.ridwan.security.connexion;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sn.ridwan.ipm.model.User;
import static sn.ridwan.security.helpers.ValidatorHelper.ComparePassword;

@ApplicationScoped
public class MyUserId{

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    public String authentificationUserId(String login,String password) {
        TypedQuery<User> typedQueryLogin = em.createQuery ("SELECT user FROM User user WHERE user.userIdd=:login AND user.isEtat=true", User.class);
        typedQueryLogin.setParameter("login", login);
        User user = typedQueryLogin.getSingleResult();
        BCrypt.Result verifyPassword = ComparePassword(password,user.getPassword());
        boolean verifyPassTrue =verifyPassword.verified ;
        if(!verifyPassTrue){
            return "Login Ou Mot De passe INCORRECT";
        }
        return String.valueOf(user.getId());
    }

}
