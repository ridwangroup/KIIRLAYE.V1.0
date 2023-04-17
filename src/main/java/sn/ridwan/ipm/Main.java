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
        Adherent um1 = new Adherent();
        Adherent um2 = new Adherent();
        Adherent um3 = new Adherent();
        Adherent um4 = new Adherent();
        Adherent um5 = new Adherent();
        Adherent um6 = new Adherent();
        Adherent um7 = new Adherent();
        Adherent um8 = new Adherent();
        Adherent um9 = new Adherent();
        Adherent um10 = new Adherent();

        //0
        um.setNom("Ba");
        um.setPrenom("Mohamed");
        um.setGenre("Masculin");
        um.setEtat(true);
        um.setEmail("mba25116@gmail.com");
        um.setNumTelephone("783703310");
        um.setIpmId("22173727ADMBA");
        um.setPassword("passer");
        um.setRole("ROLE_ADHERENT");
        um.setAdresse("Kounoune");
        um.setDateNaiss(new Date());
        um.setLieuNaiss("Malika");

        //1
        um1.setNom("Mane");
        um1.setPrenom("Seydou");
        um1.setGenre("Masculin");
        um1.setEtat(true);
        um1.setEmail("seydou-mane@gmail.com");
        um1.setNumTelephone("701773310");
        um1.setIpmId("22173727ADSM");
        um1.setPassword("passer");
        um1.setRole("ROLE_ADHERENT");
        um1.setAdresse("Diamagueune");
        um1.setDateNaiss(new Date());
        um1.setLieuNaiss("Dakar");


        //2
        um2.setNom("Dieng");
        um2.setPrenom("Haby");
        um2.setGenre("Feminin");
        um2.setEtat(true);
        um2.setEmail("habydieng@gmail.com");
        um2.setNumTelephone("779703310");
        um2.setIpmId("22173727ADHD");
        um2.setPassword("passer");
        um2.setRole("ROLE_ADHERENT");
        um2.setAdresse("Diaxaaye");
        um2.setDateNaiss(new Date());
        um2.setLieuNaiss("Dakar");

        //3
        um3.setNom("Ndiaye");
        um3.setPrenom("Serigne Modou");
        um3.setGenre("Masculin");
        um3.setEtat(true);
        um3.setEmail("modoundiaye@gmail.com");
        um3.setNumTelephone("778703310");
        um3.setIpmId("22173727ADSMN");
        um3.setPassword("passer");
        um3.setRole("ROLE_ADHERENT");
        um3.setAdresse("Diaxaaye");
        um3.setDateNaiss(new Date());
        um3.setLieuNaiss("Dakar");

        //4
        um4.setNom("Diop");
        um4.setPrenom("Awa");
        um4.setGenre("Feminin");
        um4.setEtat(true);
        um4.setEmail("diop-awa@gmail.com");
        um4.setNumTelephone("709703310");
        um4.setIpmId("22173727ADAD");
        um4.setPassword("passer");
        um4.setRole("ROLE_ADHERENT");
        um4.setAdresse("Pikine");
        um4.setDateNaiss(new Date());
        um4.setLieuNaiss("Pikine");

        //5
        um5.setNom("Mangane");
        um5.setPrenom("Abdoulahi");
        um5.setGenre("Masculin");
        um5.setEtat(true);
        um5.setEmail("abmangane14@gmail.com");
        um5.setNumTelephone("754703310");
        um5.setIpmId("22173727ADAM");
        um5.setPassword("passer");
        um5.setRole("ROLE_ADHERENT");
        um5.setAdresse("Keur Massar");
        um5.setDateNaiss(new Date());
        um5.setLieuNaiss("Kaolack");

        //6
        um6.setNom("Diop");
        um6.setPrenom("Fama Zeyna Faye");
        um6.setGenre("Feminin");
        um6.setEtat(true);
        um6.setEmail("dfzf@gmail.com");
        um6.setNumTelephone("762703310");
        um6.setIpmId("22173727ADDFZF");
        um6.setPassword("passer");
        um6.setRole("ROLE_ADHERENT");
        um6.setAdresse("Parcelles Assainies");
        um6.setDateNaiss(new Date());
        um6.setLieuNaiss("Parcelles Assainies U-26");

        //7
        um7.setNom("Diouf");
        um7.setPrenom("Serigne Mor");
        um7.setGenre("Masculin");
        um7.setEtat(true);
        um7.setEmail("diouf-mor@gmail.com");
        um7.setNumTelephone("781705312");
        um7.setIpmId("22173727ADSMD");
        um7.setPassword("passer");
        um7.setRole("ROLE_ADHERENT");
        um7.setAdresse("Darou Khoudoss");
        um7.setDateNaiss(new Date());
        um7.setLieuNaiss("Gouye Kouli");

        //8
        um8.setNom("Diallo");
        um8.setPrenom("Souleymane");
        um8.setGenre("Masculin");
        um8.setEtat(true);
        um8.setEmail("diallo-souleymane@gmail.com");
        um8.setNumTelephone("770703310");
        um8.setIpmId("22173727ADSD");
        um8.setPassword("passer");
        um8.setRole("ROLE_ADHERENT");
        um8.setAdresse("Keur Massar");
        um8.setDateNaiss(new Date());
        um8.setLieuNaiss("Medina");

        //9
        um9.setNom("Niang");
        um9.setPrenom("Oumy");
        um9.setGenre("Feminin");
        um9.setEtat(true);
        um9.setEmail("niang-oumy@gmail.com");
        um9.setNumTelephone("770700010");
        um9.setIpmId("22173727ADON");
        um9.setPassword("passer");
        um9.setRole("ROLE_ADHERENT");
        um9.setAdresse("Dakar");
        um9.setDateNaiss(new Date());
        um9.setLieuNaiss("Dakar");

        //9
        um10.setNom("Diouf");
        um10.setPrenom("Mame Birame");
        um10.setGenre("Masculin");
        um10.setEtat(true);
        um10.setEmail("diouf-birame@gmail.com");
        um10.setNumTelephone("760700010");
        um10.setIpmId("22173727ADMBD");
        um10.setPassword("passer");
        um10.setRole("ROLE_ADHERENT");
        um10.setAdresse("Sebikotane");
        um10.setDateNaiss(new Date());
        um10.setLieuNaiss("Sebikotane");

        session.beginTransaction();
        // Here we have used
        // save() method of JPA
        session.save(um);
        session.save(um1);
        session.save(um2);
        session.save(um3);
        session.save(um4);
        session.save(um5);
        session.save(um6);
        session.save(um7);
        session.save(um8);
        session.save(um9);
        session.save(um10);
        session.getTransaction().commit();
    }
}
