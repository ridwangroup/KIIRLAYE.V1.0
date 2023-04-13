package sn.ridwan.ipm.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import sn.ridwan.ipm.model.User;

import java.util.List;


@ApplicationScoped
@Transactional
public class UserserviceImpl implements  UserIservice{
    @PersistenceContext
    EntityManager em;


    @Override
    public void login(String username, String password) {
        //String regexmail = "^(.+)@(.+)$";
        //String regexTelephone = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$";

        //Validation du format de l'email
        if (username.matches("regexmail") && password.length() > 0){
            //si l'email a une correspondance a la bd   //si lepassword a une correspondance a la bd
            TypedQuery<User> query = em.createQuery("SELECT u.email,u.password FROM User u WHERE email =:username and password =:password",User.class)
                    .setParameter("username",username)
                    .setParameter("password",password);
            query.getResultList();
            //
        }
        else if (username.matches("numipm") && password.length() > 0){
            //on chercher un numero ipm comme username
            TypedQuery<User> query = em.createQuery("SELECT u.ipmId, u.password FROM User u WHERE ipmId =:username and password=:password", User.class)
                    .setParameter("username", username)
                    .setParameter("password",password);
            query.getResultList();
        } else if (username.matches("regexTelephone") && password.length() > 0) {
            //on cherche un numere de telephone comme username
            TypedQuery<User> query = em.createQuery("SELECT u.numTelephone, u.password FROM User  u WHERE numTelephone=:username and password=:password", User.class)
                    .setParameter("username", username)
                    .setParameter("password",password);
            query.getResultList();
        }
    }

    @Override
    public User findUser(String username, String password) {
        //rechercher d'user en DB
        return null;
    }

    @Override
    public User createUser(String numipm, String numphone,String email,String password) {
        User user = new User(numipm, numphone,email,password);
        em.persist(user);
        return user;
    }

    @Override
    public boolean removeUser(Long id) {
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return em.createQuery("SELECT u FROM User u",User.class).getResultList();
    }

}
