package sn.ridwan.ipm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.EntrepriseClient;

import javax.naming.NamingException;
import java.util.Date;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws NamingException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Adherent.class);

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();
        //########################>>CREATE ADHERENTS#################################
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

        EntrepriseClient ec = new EntrepriseClient();
        ec.setAdresse("Dakar");
        ec.setNinea("1945201301YUR123");
        ec.setNomEntre("RIDWAN-GROUP");
        ec.setNumRc("15687408245-RC");
        ec.setNumTele("331548767");
        ec.setEtat(true);


        //0
        um.setNom("Ba");
        um.setPrenom("Mohamed");
        um.setGenre("Masculin");
        um.setEtat(true);
        um.setEmail("mba25116@gmail.com");
        um.setNumTelephone("783703310");
        um.setUserIdd("83223760");
        //um.setPassword("passer");
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
        um1.setUserIdd("62185408");
        //um1.setPassword("passer");
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
        um2.setUserIdd("62185308");
        //um2.setPassword("passer");
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
        um3.setUserIdd("69979028");
        //um3.setPassword("passer");
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
        um4.setUserIdd("76245138");
        //um4.setPassword("passer");
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
        um5.setUserIdd("29660708");
        //um5.setPassword("passer");
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
        um6.setUserIdd("42506205");
        //um6.setPassword("passer");
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
        um7.setUserIdd("67981493");
        //um7.setPassword("passer");
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
        um8.setUserIdd("72552138");
        //um8.setPassword("passer");
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
        um9.setUserIdd("62236195");
        //um9.setPassword("passer");
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
        um10.setUserIdd("67997700");
        //um10.setPassword("passer");
        um10.setRole("ROLE_ADHERENT");
        um10.setAdresse("Sebikotane");
        um10.setDateNaiss(new Date());
        um10.setLieuNaiss("Sebikotane");
        //########################>>END ADHERENTS#################################


        //########################>>CREATE AGENTS#################################

        Agent ag1 = new Agent();
        Agent ag2 = new Agent();
        Agent ag3 = new Agent();

        //1
        ag1.setNom("Traore");
        ag1.setPrenom("Mouhamed");
        ag1.setGenre("Masculin");
        ag1.setEtat(true);
        ag1.setEmail("m-traore@gmail.com");
        ag1.setNumTelephone("780003310");
        ag1.setUserIdd("30589814");
        //ag1.setPassword("passer");
        ag1.setRole("ROLE_AGENT");
        ag1.setAdresse("Yeumbeul");
        ag1.setDateNaiss(new Date());
        ag1.setLieuNaiss("Yeumbeul");
        ag1.setMatricule("RIDWAN-IPM-19452013");
        ag1.setHierarchie("B3");
        ag1.setPoste("Developpeur");
        ag1.setImage("https://www.w3schools.com/howto/img_avatar.png");
        ag1.setConventionCollective("Article premier : OBJET ET CHAMP D'APPLICATION");

        //2
        ag2.setNom("Camara");
        ag2.setPrenom("Maoda");
        ag2.setGenre("Masculin");
        ag2.setEtat(true);
        ag2.setEmail("maoda-camara@gmail.com");
        ag2.setNumTelephone("760000310");
        ag2.setUserIdd("53611743");
        //ag2.setPassword("passer");
        ag2.setRole("ROLE_AGENT");
        ag2.setAdresse("Kounoune");
        ag2.setDateNaiss(new Date());
        ag2.setLieuNaiss("Cote d'Ivoire");
        ag2.setMatricule("RIDWAN-IPM-19451995");
        ag2.setHierarchie("B3");
        ag2.setPoste("Developpeur");
        ag2.setImage("https://www.w3schools.com/howto/img_avatar.png");
        ag2.setConventionCollective("Article 2 : PRISE D'EFFET");

        //3
        ag3.setNom("Ngom");
        ag3.setPrenom("Mame Diarra");
        ag3.setGenre("Feminin");
        ag3.setEtat(true);
        ag3.setEmail("diarra-ngom@gmail.com");
        ag3.setNumTelephone("760600310");
        ag3.setUserIdd("62934126");
        //ag3.setPassword("passer");
        ag3.setRole("ROLE_AGENT");
        ag3.setAdresse("Kounoune");
        ag3.setDateNaiss(new Date());
        ag3.setLieuNaiss("Guediawaye");
        ag3.setMatricule("RIDWAN-IPM-1945199");
        ag3.setHierarchie("B3");
        ag3.setPoste("Developpeur");
        ag3.setImage("https://www.w3schools.com/howto/img_avatar.png");
        ag3.setConventionCollective("Article 2 : PRISE D'EFFET");
        //########################>END AGENTS#################################

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
        session.save(ag1);
        session.save(ag2);
        session.save(ag3);
        session.save(ec);
        session.getTransaction().commit();
    }
}
