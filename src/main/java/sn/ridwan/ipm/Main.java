package sn.ridwan.ipm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Adresse;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.EntrepriseClient;

import javax.naming.NamingException;
import java.util.Date;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws NamingException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
       /* configuration.addAnnotatedClass(Agent.class);
        configuration.addAnnotatedClass(EntrepriseClient.class);
        configuration.addAnnotatedClass(Adherent.class);
        configuration.addAnnotatedClass(Adresse.class);*/

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //########################>>CREATE AGENTS#################################
        // Initialize Session Object
        Session session1 = sessionFactory.openSession();

        Agent ag = new Agent();
        Agent ag1 = new Agent();
        Agent ag2 = new Agent();
        Agent ag3 = new Agent();
        Agent ag4 = new Agent();

        //0
        ag.setNom("Camara");
        ag.setPrenom("Awa");
        ag.setGenre("Feminin");
        ag.setAg_email("a-camara@ridwan.com");
        ag.setAg_tel("780000010");
        ag.setMatricule("MAT-30501814");
        ag.setUserIdd(ag.getMatricule());
        ag.setRole("ROLE_AGENT");
        ag.setAdresse("Bargny");
        ag.setLieuNaiss("Bargny");
        //ag.setMatricule("RIDWAN-IPM-19498013");
        ag.setHierarchie("B3");
        ag.setPoste("Developpeur");
        ag.setConventionCollective("B2");

        //1
        ag1.setNom("Traore");
        ag1.setPrenom("Mouhamed");
        ag1.setGenre("Masculin");
        ag1.setAg_email("m-traore@ridwan.com");
        ag1.setAg_tel("780003310");
        ag1.setMatricule("MAT-30589814");
        ag1.setUserIdd(ag1.getMatricule());
        ag1.setRole("ROLE_AGENT");
        ag1.setAdresse("Yeumbeul");
        ag1.setLieuNaiss("Yeumbeul");
        //ag1.setMatricule("RIDWAN-IPM-19452013");
        ag1.setConventionCollective("B3");
        ag1.setPoste("Developpeur");
        ag1.setHierarchie("B3");

        //2
        ag2.setNom("Camara");
        ag2.setPrenom("Maoda");
        ag2.setGenre("Masculin");
        ag2.setAg_email("maoda-camara@ridwan.com");
        ag2.setAg_tel("760000310");
        ag2.setMatricule("MAT-53611743");
        ag2.setUserIdd(ag2.getMatricule());
        ag2.setRole("ROLE_AGENT");
        ag2.setAdresse("Kounoune");
        ag2.setLieuNaiss("Cote d'Ivoire");
        //ag2.setMatricule("RIDWAN-IPM-19451995");
        ag2.setConventionCollective("B1");
        ag2.setPoste("Developpeur");
        ag2.setHierarchie("B3");


        //3
        ag3.setNom("Ngom");
        ag3.setPrenom("Mame Diarra");
        ag3.setGenre("Feminin");
        ag3.setAg_email("diarra-ngom@ridwan.com");
        ag3.setAg_tel("760600310");
        ag3.setMatricule("MAT-62934126");
        ag3.setUserIdd(ag3.getMatricule());
        ag3.setRole("ROLE_AGENT");
        ag3.setAdresse("Kounoune");
        ag3.setLieuNaiss("Guediawaye");
       // ag3.setMatricule("RIDWAN-IPM-1945199");
        ag3.setConventionCollective("B5");
        ag3.setPoste("Assistante");
        ag3.setHierarchie("B3");


        //4
        ag4.setNom("Ba");
        ag4.setPrenom("Aicha");
        ag4.setGenre("Feminin");
        ag4.setAg_email("aicha-ba@ridwan.com");
        ag4.setAg_tel("785055747");
        ag4.setMatricule("MAT-10134126");
        ag4.setUserIdd(ag4.getMatricule());
        ag4.setRole("ROLE_AGENT");
        ag4.setAdresse("Kounoune");
        ag4.setLieuNaiss("Guediawaye");
        //ag4.setMatricule("RIDWAN-IPM-1992199");
        ag4.setConventionCollective("B6");
        ag4.setPoste("Assistante");
        ag4.setHierarchie("B3");


        session1.beginTransaction();
        // Here we have used
        // update() method of JPA
        session1.save(ag);
        session1.save(ag1);
        session1.save(ag2);
        session1.save(ag3);
        session1.save(ag4);
        session1.getTransaction().commit();
        session1.close();
        //########################>END AGENTS##############################################


        //########################>>CREATE EntrepriseClient#################################
        // Initialize Session Object
        Session session2 = sessionFactory.openSession();

        EntrepriseClient ec = new EntrepriseClient();
        EntrepriseClient ec1 = new EntrepriseClient();
        EntrepriseClient ec2 = new EntrepriseClient();
        EntrepriseClient ec3 = new EntrepriseClient();
        EntrepriseClient ec4 = new EntrepriseClient();

        //0
        ec.setNomEntreprise("RIDWAN-GROUP");
        ec.setNinea("1945201301YUR123");
        ec.setNumRegCommerce("15687408245-RC");
        ec.setNumeroTelephone("331548767");
        ec.setEmailEntreprise("ridwan@support.com");
        ec.setAdresse(new Adresse("Matam","Matam","KhoreFonde","Matam","MboloBirane"));
        ec.setAgent(new Agent(ag.getId()));

        //1
        ec1.setNomEntreprise("GROUP-SONATEL");
        ec1.setNinea("192013201301ZRE123");
        ec1.setNumRegCommerce("10087408245-RC");
        ec1.setNumeroTelephone("330548767");
        ec1.setEmailEntreprise("sonatel@support.com");
        ec1.setAdresse(new Adresse("Dakar","Dakar","Sacre Coeur","Dakar","Cite Keur Gorgui"));
        ec1.setAgent(new Agent(4L));

        //2
        ec2.setNomEntreprise("GROUP-FREE");
        ec2.setNinea("192013201301FREE123");
        ec2.setNumRegCommerce("10047888245-RC");
        ec2.setNumeroTelephone("333548767");
        ec2.setEmailEntreprise("free@support.com");
        ec2.setAdresse(new Adresse("Dakar","Dakar","Foire","Dakar","Parcelles Assainies"));
        ec2.setAgent(new Agent(2L));

        //3
        ec3.setNomEntreprise("GROUP-EXPRESSO");
        ec3.setNinea("192013201301EXPR123");
        ec3.setNumRegCommerce("10147888045-RC");
        ec3.setNumeroTelephone("334548767");
        ec3.setEmailEntreprise("expresso@support.com");
        ec3.setAdresse(new Adresse("Dakar","Dakar","Saint Lazar","Dakar","VDN"));
        ec3.setAgent(new Agent(3L));

        //4
        ec4.setNomEntreprise("GROUP-GAINDE-2000");
        ec4.setNinea("192013201301GD2000123");
        ec4.setNumRegCommerce("10047888048-RC");
        ec4.setNumeroTelephone("335548767");
        ec4.setEmailEntreprise("gainde-2000@support.com");
        ec4.setAdresse(new Adresse("Dakar","Dakar","plateau","Dakar","Point E"));
        ec4.setAgent(new Agent(5L));

        session2.beginTransaction();

        session2.save(ec);
        session2.save(ec1);
        session2.save(ec2);
        session2.save(ec3);
        session2.save(ec4);

        session2.getTransaction().commit();

        session2.close();

        //########################>>CREATE ADHERENTS#################################*/
        // Initialize Session Object
        Session session3 = sessionFactory.openSession();
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
        um.setAd_email("mba25116@gmail.com");
        um.setAd_tel("783703310");
        um.setIpmID("IPM-83223760");
        um.setUserIdd(um.getIpmID());
        um.setRole("ROLE_ADHERENT");
        um.setAdresse("Kounoune");
        um.setLieuNaiss("Malika");
        um.setAgent(new Agent(1L));
        um.setEntrepriseClients(new EntrepriseClient(5L));

        //1
        um1.setNom("Mane");
        um1.setPrenom("Seydou");
        um1.setGenre("Masculin");
        um1.setAd_email("seydou-mane@gmail.com");
        um1.setAd_tel("701773310");
        um1.setIpmID("IPM-62185408");
        um1.setUserIdd(um1.getIpmID());
        um1.setRole("ROLE_ADHERENT");
        um1.setAdresse("Diamagueune");
        um1.setLieuNaiss("Dakar");
        um1.setAgent(new Agent(2L));
        um1.setEntrepriseClients(new EntrepriseClient(4L));

        //2
        um2.setNom("Dieng");
        um2.setPrenom("Haby");
        um2.setGenre("Feminin");
        um2.setAd_email("habydieng@gmail.com");
        um2.setAd_tel("779703310");
        um2.setIpmID("IPM-62185308");
        um2.setUserIdd(um2.getIpmID());
        um2.setRole("ROLE_ADHERENT");
        um2.setAdresse("Diaxaaye");
        um2.setLieuNaiss("Dakar");
        um2.setAgent(new Agent(3L));
        um2.setEntrepriseClients(new EntrepriseClient(3L));

        //3
        um3.setNom("Ndiaye");
        um3.setPrenom("Serigne Modou");
        um3.setGenre("Masculin");
        um3.setAd_email("modoundiaye@gmail.com");
        um3.setAd_tel("778703310");
        um3.setIpmID("IPM-69979028");
        um3.setUserIdd(um3.getIpmID());
        um3.setRole("ROLE_ADHERENT");
        um3.setAdresse("Diaxaaye");
        um3.setLieuNaiss("Dakar");
        um3.setAgent(new Agent(4L));
        um3.setEntrepriseClients(new EntrepriseClient(2L));

        //4
        um4.setNom("Diop");
        um4.setPrenom("Awa");
        um4.setGenre("Feminin");
        um4.setAd_email("diop-awa@gmail.com");
        um4.setAd_tel("709703310");
        um4.setIpmID("IPM-76245138");
        um4.setUserIdd(um4.getIpmID());
        um4.setRole("ROLE_ADHERENT");
        um4.setAdresse("Pikine");
        um4.setLieuNaiss("Pikine");
        um4.setAgent(new Agent(5L));
        um4.setEntrepriseClients(new EntrepriseClient(1L));

        //5
        um5.setNom("Mangane");
        um5.setPrenom("Abdoulahi");
        um5.setGenre("Masculin");
        um5.setAd_email("abmangane14@gmail.com");
        um5.setAd_tel("754703310");
        um5.setIpmID("IPM-29660708");
        um5.setUserIdd(um5.getIpmID());
        um5.setRole("ROLE_ADHERENT");
        um5.setAdresse("Keur Massar");
        um5.setLieuNaiss("Kaolack");
        um5.setAgent(new Agent(3L));
        um5.setEntrepriseClients(new EntrepriseClient(5L));

        //6
        um6.setNom("Diop");
        um6.setPrenom("Fama Zeyna Faye");
        um6.setGenre("Feminin");
        um6.setAd_email("dfzf@gmail.com");
        um6.setAd_tel("762703310");
        um6.setIpmID("IPM-42506205");
        um6.setUserIdd(um6.getIpmID());
        um6.setRole("ROLE_ADHERENT");
        um6.setAdresse("Parcelles Assainies");
        um6.setLieuNaiss("Parcelles Assainies U-26");
        um6.setAgent(new Agent(2L));
        um6.setEntrepriseClients(new EntrepriseClient(3L));

        //7
        um7.setNom("Diouf");
        um7.setPrenom("Serigne Mor");
        um7.setGenre("Masculin");
        um7.setAd_email("diouf-mor@gmail.com");
        um7.setAd_tel("781705312");
        um7.setIpmID("IPM-67981493");
        um7.setUserIdd(um7.getIpmID());
        um7.setRole("ROLE_ADHERENT");
        um7.setAdresse("Darou Khoudoss");
        um7.setLieuNaiss("Gouye Kouli");
        um7.setAgent(new Agent(3L));
        um7.setEntrepriseClients(new EntrepriseClient(2L));

        //8
        um8.setNom("Diallo");
        um8.setPrenom("Souleymane");
        um8.setGenre("Masculin");
        um8.setAd_email("diallo-souleymane@gmail.com");
        um8.setAd_tel("770703310");
        um8.setIpmID("IPM-72552138");
        um8.setUserIdd(um8.getIpmID());
        um8.setRole("ROLE_ADHERENT");
        um8.setAdresse("Keur Massar");
        um8.setLieuNaiss("Medina");
        um8.setAgent(new Agent(5L));
        um8.setEntrepriseClients(new EntrepriseClient(4L));

        //9
        um9.setNom("Niang");
        um9.setPrenom("Oumy");
        um9.setGenre("Feminin");
        um9.setAd_email("niang-oumy@gmail.com");
        um9.setAd_tel("770700010");
        um9.setIpmID("IPM-62236195");
        um9.setUserIdd(um9.getIpmID());
        um9.setRole("ROLE_ADHERENT");
        um9.setAdresse("Dakar");
        um9.setLieuNaiss("Dakar");
        um9.setAgent(new Agent(4L));
        um9.setEntrepriseClients(new EntrepriseClient(5L));

        //9
        um10.setNom("Diouf");
        um10.setPrenom("Mame Birame");
        um10.setGenre("Masculin");
        um10.setAd_email("diouf-birame@gmail.com");
        um10.setAd_tel("760700010");
        um10.setIpmID("IPM-67997700");
        um10.setUserIdd(um10.getIpmID());
        um10.setRole("ROLE_ADHERENT");
        um10.setAdresse("Sebikotane");
        um10.setLieuNaiss("Sebikotane");
        um10.setAgent(new Agent(3L));
        um10.setEntrepriseClients(new EntrepriseClient(1L));

        session3.beginTransaction();
        session3.save(um);
        session3.save(um1);
        session3.save(um2);
        session3.save(um3);
        session3.save(um4);
        session3.save(um5);
        session3.save(um6);
        session3.save(um7);
        session3.save(um8);
        session3.save(um9);
        session3.save(um10);

        session3.getTransaction().commit();
        session3.close();
        //########################>>END ADHERENTS#################################*/
    }
}
