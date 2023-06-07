package sn.ridwan.security.connexion;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sn.ridwan.ipm.model.User;

import static sn.ridwan.security.helpers.ValidatorHelper.ComparePassword;

@ApplicationScoped
public class MyEmail{

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    public String  authentificationEmail(String login,String password) {
        TypedQuery<User> typedQueryLogin = em.createQuery("SELECT user FROM User user WHERE user.email=:login AND user.isEtat=true", User.class);
        typedQueryLogin.setParameter("login", login);
        User user = typedQueryLogin.getSingleResult();
        BCrypt.Result verifyPassword = ComparePassword(password,user.getPassword());
        boolean verifyPassTrue =verifyPassword.verified ;

        if(!verifyPassTrue){
            return "Login Ou Mot De passe INCORRECT";
        }
      /*  if(user.isFirstConnection()==true){

            String msg = "Ceci est votre premiére connexion!\nSvp veuillez changer votre mot de passe avant de pouvoir continuer!";
            System.out.println("########user.isFirstConnection() : "+user.isFirstConnection());
            return  msg;
           //return Response.ok("{\"firstConnection\": \"" + msg + "\"}").build().toString();
           // return String.valueOf(user.getId());
        }*/
        return String.valueOf(user.getId());
    }

}