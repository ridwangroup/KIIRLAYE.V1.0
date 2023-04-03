package sn.ridwan.ipm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sn.ridwan.ipm.model.Adherent;
import javax.naming.NamingException;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws NamingException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Adherent.class);

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();
        Adherent um = new Adherent();
        um.setPrenom("Mohamed Lamine");
        um.setNom("Ba");
        um.setEmail("mba25116@gmail.com");
        um.setAdresse("Kounoune");
        um.setNumTelephone("783703310");
        um.setIpmId("22173727");
        um.setEtat(true);
        um.setLieuNaiss("Malika");
        um.setDateNaiss(new Date());
        um.setPassword("passer");

        session.beginTransaction();
        // Here we have used
        // save() method of JPA
        session.save(um);
        session.getTransaction().commit();
    }
}
