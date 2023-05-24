package sn.ridwan.ipm.services.implement;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.services.interfaces.userInterface;

public  class userImplement implements userInterface {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Override
    public String HashDefaultPassword(String plainPassword) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        return bcryptHashString;
    }

    public User getUserByEmail(String login){
        System.out.println("login in getUserByEmail : "+login);
        TypedQuery<User> findByEmail =em.createQuery("SELECT user FROM User user WHERE user.email=:login",User.class);
        findByEmail.setParameter("login",login);
        User obj = findByEmail.getSingleResult();
       return  obj;
    }

}
