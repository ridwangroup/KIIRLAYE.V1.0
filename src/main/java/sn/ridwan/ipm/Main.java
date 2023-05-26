package sn.ridwan.ipm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sn.ridwan.ipm.model.*;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws NamingException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        //########################>>CREATE ROLES#################################
        // Initialize Session Object
        Session session0 = sessionFactory.openSession();
        RolesPermissions roles = new RolesPermissions();
        RolesPermissions roles1 = new RolesPermissions();
        RolesPermissions roles2 = new RolesPermissions();
        roles.setRoleName("ADMIN");
        roles1.setRoleName("AGENT");
        roles2.setRoleName("ADHERENT");

        session0.beginTransaction();
        session0.save(roles);
        session0.save(roles1);
        session0.save(roles2);
        session0.getTransaction().commit();
        session0.close();




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
        ag.setEmail(ag.getAg_email());
        ag.setAg_tel("780000010");
        ag.setTel(ag.getAg_tel());
        ag.setMatricule("MAT-30501814");
        ag.setUserIdd(ag.getMatricule());
        ag.setAdresse("Bargny");
        ag.setLieuNaiss("Bargny");
        ag.setHierarchie("B3");
        ag.setPoste("Developpeur");
        ag.setConventionCollective("B2");
        ag.setFirstConnection(true);
        ag.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT,Role.AGENT,Role.ADMIN)));



        //1
        ag1.setNom("Traore");
        ag1.setPrenom("Mouhamed");
        ag1.setGenre("Masculin");
        ag1.setAg_email("m-traore@ridwan.com");
        ag1.setEmail(ag1.getAg_email());
        ag1.setAg_tel("780003310");
        ag1.setTel(ag1.getAg_tel());
        ag1.setMatricule("MAT-30589814");
        ag1.setUserIdd(ag1.getMatricule());
        ag1.setAdresse("Yeumbeul");
        ag1.setLieuNaiss("Yeumbeul");
        ag1.setConventionCollective("B3");
        ag1.setPoste("Developpeur");
        ag1.setHierarchie("B3");
        ag1.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT,Role.AGENT)));
        ag1.setRolesList(java.util.List.of(roles1));
        //ag1.addRole(roles1);
       // ag1.addRole(roles2);

        //2
        ag2.setNom("Camara");
        ag2.setPrenom("Maoda");
        ag2.setGenre("Masculin");
        ag2.setAg_email("maoda-camara@ridwan.com");
        ag2.setEmail(ag2.getAg_email());
        ag2.setAg_tel("760000310");
        ag2.setTel(ag2.getAg_tel());
        ag2.setMatricule("MAT-53611743");
        ag2.setUserIdd(ag2.getMatricule());
        ag2.setAdresse("Kounoune");
        ag2.setLieuNaiss("Cote d'Ivoire");
        ag2.setConventionCollective("B1");
        ag2.setPoste("Developpeur");
        ag2.setHierarchie("B3");
        ag2.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT,Role.AGENT)));

        //3
        ag3.setNom("Ngom");
        ag3.setPrenom("Mame Diarra");
        ag3.setGenre("Feminin");
        ag3.setAg_email("diarra-ngom@ridwan.com");
        ag3.setEmail(ag3.getAg_email());
        ag3.setAg_tel("760600310");
        ag3.setTel(ag3.getAg_tel());
        ag3.setMatricule("MAT-62934126");
        ag3.setUserIdd(ag3.getMatricule());
        ag3.setAdresse("Kounoune");
        ag3.setLieuNaiss("Guediawaye");
        ag3.setConventionCollective("B5");
        ag3.setPoste("Assistante");
        ag3.setHierarchie("B3");
        ag3.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT,Role.AGENT)));

        //4
        ag4.setNom("Ba");
        ag4.setPrenom("Aicha");
        ag4.setGenre("Feminin");
        ag4.setAg_email("aicha-ba@ridwan.com");
        ag4.setEmail(ag4.getAg_email());
        ag4.setAg_tel("785055747");
        ag4.setTel(ag4.getAg_tel());
        ag4.setMatricule("MAT-10134126");
        ag4.setUserIdd(ag4.getMatricule());
        ag4.setAdresse("Kounoune");
        ag4.setLieuNaiss("Guediawaye");
        ag4.setConventionCollective("B6");
        ag4.setPoste("Assistante");
        ag4.setHierarchie("B3");
        ag4.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT,Role.AGENT)));
       // ag4.addUserRole(new User_Roles(roles1));



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


        //########################>>CREATE USERS-ROLES#################################

       /* Session session10 = sessionFactory.openSession();
        User_Roles ur = new User_Roles();
        User_Roles ur1 = new User_Roles();
        ur.setRoles_permissions(roles2);
        ur.setUser(ag);

        ur1.setRoles_permissions(roles1);
        ur1.setUser(ag);

        session10.beginTransaction();
        // Here we have used
        // update() method of JPA

        session10.save(ur);
        session10.save(ur1);
        session10.getTransaction().commit();


        session10.close();*/







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
        um.setEmail(um.getAd_email());
        um.setAd_tel("783703310");
        um.setTel(um.getAd_tel());
        um.setIpmID("RIDCA-83223760");
        um.setUserIdd(um.getIpmID());
        um.setAdresse("Kounoune");
        um.setLieuNaiss("Malika");
        um.setAgent(new Agent(1L));
        um.setEntrepriseClients(new EntrepriseClient(5L));
        um.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um.setCreateAtBy(um.getAgent().getId());
        um.setUpdateAtBy(um.getAgent().getId());

        //1
        um1.setNom("Mane");
        um1.setPrenom("Seydou");
        um1.setGenre("Masculin");
        um1.setAd_email("seydou-mane@gmail.com");
        um1.setEmail(um1.getAd_email());
        um1.setAd_tel("701773310");
        um1.setTel(um1.getAd_tel());
        um1.setIpmID("RIDCA-62185408");
        um1.setUserIdd(um1.getIpmID());
        um1.setAdresse("Diamagueune");
        um1.setLieuNaiss("Dakar");
        um1.setAgent(new Agent(2L));
        um1.setEntrepriseClients(new EntrepriseClient(4L));
        um1.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um1.setCreateAtBy(um1.getAgent().getId());
        um1.setUpdateAtBy(um1.getAgent().getId());

        //2
        um2.setNom("Dieng");
        um2.setPrenom("Haby");
        um2.setGenre("Feminin");
        um2.setAd_email("habydieng@gmail.com");
        um2.setEmail(um2.getAd_email());
        um2.setAd_tel("779703310");
        um2.setTel(um2.getAd_tel());
        um2.setIpmID("RIDCA-62185308");
        um2.setUserIdd(um2.getIpmID());
        um2.setAdresse("Diaxaaye");
        um2.setLieuNaiss("Dakar");
        um2.setAgent(new Agent(3L));
        um2.setEntrepriseClients(new EntrepriseClient(3L));
        um2.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um2.setCreateAtBy(um2.getAgent().getId());
        um2.setUpdateAtBy(um2.getAgent().getId());

        //3
        um3.setNom("Ndiaye");
        um3.setPrenom("Serigne Modou");
        um3.setGenre("Masculin");
        um3.setAd_email("modoundiaye@gmail.com");
        um3.setEmail(um3.getAd_email());
        um3.setAd_tel("778703310");
        um3.setTel(um3.getAd_tel());
        um3.setIpmID("RIDCA-69979028");
        um3.setUserIdd(um3.getIpmID());
        um3.setAdresse("Diaxaaye");
        um3.setLieuNaiss("Dakar");
        um3.setAgent(new Agent(4L));
        um3.setEntrepriseClients(new EntrepriseClient(2L));
        um3.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um3.setCreateAtBy(um3.getAgent().getId());
        um3.setUpdateAtBy(um3.getAgent().getId());

        //4
        um4.setNom("Diop");
        um4.setPrenom("Awa");
        um4.setGenre("Feminin");
        um4.setAd_email("diop-awa@gmail.com");
        um4.setEmail(um4.getAd_email());
        um4.setAd_tel("709703310");
        um4.setTel(um4.getAd_tel());
        um4.setIpmID("RIDCA-76245138");
        um4.setUserIdd(um4.getIpmID());
        um4.setAdresse("Pikine");
        um4.setLieuNaiss("Pikine");
        um4.setAgent(new Agent(5L));
        um4.setEntrepriseClients(new EntrepriseClient(1L));
        um4.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um4.setCreateAtBy(um4.getAgent().getId());
        um4.setUpdateAtBy(um4.getAgent().getId());

        //5
        um5.setNom("Mangane");
        um5.setPrenom("Abdoulahi");
        um5.setGenre("Masculin");
        um5.setAd_email("abmangane14@gmail.com");
        um5.setEmail(um5.getAd_email());
        um5.setAd_tel("754703310");
        um5.setTel(um5.getAd_tel());
        um5.setIpmID("RIDCA-29660708");
        um5.setUserIdd(um5.getIpmID());
        um5.setAdresse("Keur Massar");
        um5.setLieuNaiss("Kaolack");
        um5.setAgent(new Agent(3L));
        um5.setEntrepriseClients(new EntrepriseClient(5L));
        um5.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um5.setCreateAtBy(um5.getAgent().getId());
        um5.setUpdateAtBy(um5.getAgent().getId());

        //6
        um6.setNom("Diop");
        um6.setPrenom("Fama Zeyna Faye");
        um6.setGenre("Feminin");
        um6.setAd_email("dfzf@gmail.com");
        um6.setEmail(um6.getAd_email());
        um6.setAd_tel("762703310");
        um6.setTel(um6.getAd_tel());
        um6.setIpmID("RIDCA-42506205");
        um6.setUserIdd(um6.getIpmID());
        um6.setAdresse("Parcelles Assainies");
        um6.setLieuNaiss("Parcelles Assainies U-26");
        um6.setAgent(new Agent(2L));
        um6.setEntrepriseClients(new EntrepriseClient(3L));
        um6.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um6.setCreateAtBy(um6.getAgent().getId());
        um6.setUpdateAtBy(um6.getAgent().getId());

        //7
        um7.setNom("Diouf");
        um7.setPrenom("Serigne Mor");
        um7.setGenre("Masculin");
        um7.setAd_email("diouf-mor@gmail.com");
        um7.setEmail(um7.getAd_email());
        um7.setAd_tel("781705312");
        um7.setTel(um7.getAd_tel());
        um7.setIpmID("RIDCA-67981493");
        um7.setUserIdd(um7.getIpmID());
        um7.setAdresse("Darou Khoudoss");
        um7.setLieuNaiss("Gouye Kouli");
        um7.setAgent(new Agent(3L));
        um7.setEntrepriseClients(new EntrepriseClient(2L));
        um7.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um7.setCreateAtBy(um7.getAgent().getId());
        um7.setUpdateAtBy(um7.getAgent().getId());

        //8
        um8.setNom("Diallo");
        um8.setPrenom("Souleymane");
        um8.setGenre("Masculin");
        um8.setAd_email("diallo-souleymane@gmail.com");
        um8.setEmail(um8.getAd_email());
        um8.setAd_tel("770703310");
        um8.setTel(um8.getAd_tel());
        um8.setIpmID("RIDCA-72552138");
        um8.setUserIdd(um8.getIpmID());
        um8.setEmail(um8.getAd_email());
        um8.setAdresse("Keur Massar");
        um8.setLieuNaiss("Medina");
        um8.setAgent(new Agent(5L));
        um8.setEntrepriseClients(new EntrepriseClient(4L));
        um8.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um8.setCreateAtBy(um8.getAgent().getId());
        um8.setUpdateAtBy(um8.getAgent().getId());

        //9
        um9.setNom("Niang");
        um9.setPrenom("Oumy");
        um9.setGenre("Feminin");
        um9.setAd_email("niang-oumy@gmail.com");
        um9.setEmail(um9.getAd_email());
        um9.setAd_tel("770700010");
        um9.setTel(um9.getAd_tel());
        um9.setIpmID("RIDCA-62236195");
        um9.setUserIdd(um9.getIpmID());
        um9.setAdresse("Dakar");
        um9.setLieuNaiss("Dakar");
        um9.setAgent(new Agent(4L));
        um9.setEntrepriseClients(new EntrepriseClient(5L));
        um9.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um9.setCreateAtBy(um9.getAgent().getId());
        um9.setUpdateAtBy(um9.getAgent().getId());

        //9
        um10.setNom("Diouf");
        um10.setPrenom("Mame Birame");
        um10.setGenre("Masculin");
        um10.setAd_email("diouf-birame@gmail.com");
        um10.setEmail(um10.getAd_email());
        um10.setAd_tel("760700010");
        um10.setIpmID("RIDCA-67997700");
        um10.setTel(um10.getAd_tel());
        um10.setUserIdd(um10.getIpmID());
        um10.setAdresse("Sebikotane");
        um10.setLieuNaiss("Sebikotane");
        um10.setAgent(new Agent(3L));
        um10.setEntrepriseClients(new EntrepriseClient(1L));
        um10.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        um10.setCreateAtBy(um10.getAgent().getId());
        um10.setUpdateAtBy(um10.getAgent().getId());

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
