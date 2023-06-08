package sn.ridwan.ipm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sn.ridwan.ipm.model.*;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws NamingException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //########################>>CREATE ROLES#################################
        // Initialize Session Object
     /*   Session session0 = sessionFactory.openSession();
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
        session0.close();*/

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
        ag.setEmail("a-camara@ridwan.com");
        ag.setTel("780000010");
        ag.setUserIdd("MAT-30501814");
        ag.setAdresse("Bargny");
        ag.setLieuNaiss("Bargny");
        ag.setHierarchie("B3");
        ag.setPoste("Developpeur");
        ag.setConventionCollective("B2");
        ag.setFirstConnection(true);
        ag.setRoles(new ArrayList<Role>(Arrays.asList(Role.AGENT,Role.ADMIN)));
        ag.setCreateBy(1L);
        ag.setUpdateBy(1L);

        //1
        ag1.setNom("Traore");
        ag1.setPrenom("Mouhamed");
        ag1.setGenre("Masculin");
        ag1.setEmail("m-traore@ridwan.com");
        ag1.setTel("780003310");
        ag1.setUserIdd("MAT-30589814");
        ag1.setAdresse("Yeumbeul");
        ag1.setLieuNaiss("Yeumbeul");
        ag1.setConventionCollective("B3");
        ag1.setPoste("Developpeur");
        ag1.setHierarchie("B3");
        ag1.setRoles(new ArrayList<Role>(Arrays.asList(Role.AGENT)));
        ag1.setCreateBy(1L);
        ag1.setUpdateBy(1L);

        //2
        ag2.setNom("Camara");
        ag2.setPrenom("Maoda");
        ag2.setGenre("Masculin");
        ag2.setEmail("maoda-camara@ridwan.com");
        ag2.setTel("760000310");
        ag2.setUserIdd("MAT-53611743");
        ag2.setAdresse("Kounoune");
        ag2.setLieuNaiss("Cote d'Ivoire");
        ag2.setConventionCollective("B1");
        ag2.setPoste("Developpeur");
        ag2.setHierarchie("B3");
        ag2.setRoles(new ArrayList<Role>(Arrays.asList(Role.AGENT)));
        ag2.setCreateBy(1L);
        ag2.setUpdateBy(1L);

        //3
        ag3.setNom("Ngom");
        ag3.setPrenom("Mame Diarra");
        ag3.setGenre("Feminin");
        ag3.setEmail("diarra-ngom@ridwan.com");
        ag3.setTel("760600310");
        ag3.setUserIdd("MAT-62934126");
        ag3.setAdresse("Kounoune");
        ag3.setLieuNaiss("Guediawaye");
        ag3.setConventionCollective("B5");
        ag3.setPoste("Assistante");
        ag3.setHierarchie("B3");
        ag3.setRoles(new ArrayList<Role>(Arrays.asList(Role.AGENT)));
        ag3.setCreateBy(1L);
        ag3.setUpdateBy(1L);
        ag3.setEtat(false);

        //4
        ag4.setNom("Ba");
        ag4.setPrenom("Aicha");
        ag4.setGenre("Feminin");
        ag4.setEmail("aicha-ba@ridwan.com");
        ag4.setTel("785055747");
        ag4.setUserIdd("MAT-10134126" );
        ag4.setAdresse("Kounoune");
        ag4.setLieuNaiss("Guediawaye");
        ag4.setConventionCollective("B6");
        ag4.setPoste("Assistante");
        ag4.setHierarchie("B3");
        ag4.setRoles(new ArrayList<Role>(Arrays.asList(Role.AGENT)));
        ag4.setCreateBy(1L);
        ag4.setUpdateBy(1L);
        ag4.setEtat(false);

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
        ec.setAdresse(new Adresse("Senegal","Matam","Matam","KhoreFonde","MboloBirane",38,21));
        ec.setCreateBy(new Agent(ag.getId()));
        ec.setUpdateBy(1L);
        ec.setEtatEntreprise(true);

        //1
        ec1.setNomEntreprise("GROUP-SONATEL");
        ec1.setNinea("192013201301ZRE123");
        ec1.setNumRegCommerce("10087408245-RC");
        ec1.setNumeroTelephone("330548767");
        ec1.setEmailEntreprise("sonatel@support.com");
        ec1.setAdresse(new Adresse("Senegal","Dakar","Dakar","Dakar","Cite Keur Gorgui",52,81));
        ec1.setCreateBy(new Agent(4L));
        //ec1.setCreateAtBy(1L);
        ec1.setUpdateBy(4L);
        ec1.setEtatEntreprise(true);

        //2
        ec2.setNomEntreprise("GROUP-FREE");
        ec2.setNinea("192013201301FREE123");
        ec2.setNumRegCommerce("10047888245-RC");
        ec2.setNumeroTelephone("333548767");
        ec2.setEmailEntreprise("free@support.com");
        ec2.setAdresse(new Adresse("Senegal","Dakar","Dakar","Dakar","Parcelles Assainies Unite 10",32,21));
        ec2.setCreateBy(new Agent(2L));
        //ec2.setCreateAtBy(1L);
        ec2.setUpdateBy(2L);
        ec2.setEtatEntreprise(true);

        //3
        ec3.setNomEntreprise("GROUP-EXPRESSO");
        ec3.setNinea("192013201301EXPR123");
        ec3.setNumRegCommerce("10147888045-RC");
        ec3.setNumeroTelephone("334548767");
        ec3.setEmailEntreprise("expresso@support.com");
        ec3.setAdresse(new Adresse("Senegal","Dakar","Dakar","Dakar","Foire rue 14",12,41));
        ec3.setCreateBy(new Agent(3L));
        //ec3.setCreateAtBy(1L);
        ec3.setUpdateBy(3L);

        //4
        ec4.setNomEntreprise("GROUP-GAINDE-2000");
        ec4.setNinea("192013201301GD2000123");
        ec4.setNumRegCommerce("10047888048-RC");
        ec4.setNumeroTelephone("335548767");
        ec4.setEmailEntreprise("gainde-2000@support.com");
        ec4.setAdresse(new Adresse("Senegal","Dakar","Dakar","Dakar","Point E rue 7",22,20));
        ec4.setCreateBy(new Agent(5L));
        //ec4.setCreateAtBy(1L);
        ec4.setUpdateBy(5L);

        session2.beginTransaction();

        session2.save(ec);
        session2.save(ec1);
        session2.save(ec2);
        session2.save(ec3);
        session2.save(ec4);

        session2.getTransaction().commit();
        session2.close();

        //########################>>CREATE Contrat#################################
        // Initialize Session Object
        Session session5 = sessionFactory.openSession();
        Contrat contrat = new Contrat();
        Contrat contrat1 = new Contrat();
        Contrat contrat2= new Contrat();
        Contrat contrat3 = new Contrat();
        Contrat contrat4 = new Contrat();

        //1
        contrat.setDate_signature(new Date(113,10,12));
        contrat.setDate_entree_vigueur(new Date(113,11,12));
        contrat.setDate_fin_contrat(new Date(114,11,12));
        contrat.setCopie_contrat("copieContrat.pdf");
        contrat.setEntrepriseClients(new EntrepriseClient(ec.getId()));
        contrat.setPeriodicite_contrat(new ArrayList<PeriodiciteContrat>(Arrays.asList(PeriodiciteContrat.MENSUELX3)));

        //2
        contrat1.setDate_signature(new Date(118,5,7));
        contrat1.setDate_entree_vigueur(new Date(118,06,7));
        contrat1.setDate_fin_contrat(new Date(119,6,7));
        contrat1.setCopie_contrat("copieContrat.pdf");
        contrat1.setEntrepriseClients(new EntrepriseClient(ec1.getId()));
        contrat1.setPeriodicite_contrat(new ArrayList<PeriodiciteContrat>(Arrays.asList(PeriodiciteContrat.MENSUEL)));

        //3
        contrat2.setDate_signature(new Date(116,9,19));
        contrat2.setDate_entree_vigueur(new Date(116,10,19));
        contrat2.setDate_fin_contrat(new Date(117,10,19));
        contrat2.setCopie_contrat("copieContrat.pdf");
        contrat2.setEntrepriseClients(new EntrepriseClient(ec2.getId()));
        contrat2.setPeriodicite_contrat(new ArrayList<PeriodiciteContrat>(Arrays.asList(PeriodiciteContrat.MENSUELX2)));

        //4
        contrat3.setDate_signature(new Date(121,4,11));
        contrat3.setDate_entree_vigueur(new Date(121,5,11));
        contrat3.setDate_fin_contrat(new Date(122,5,11));
        contrat3.setCopie_contrat("copieContrat.pdf");
        contrat3.setEntrepriseClients(new EntrepriseClient(ec3.getId()));
        contrat3.setEtatContrat(false);
        contrat3.setPeriodicite_contrat(new ArrayList<PeriodiciteContrat>(Arrays.asList(PeriodiciteContrat.MENSUEL)));

        //5
        contrat4.setDate_signature(new Date(123,1,1));
        contrat4.setDate_entree_vigueur(new Date(123,2,1));
        contrat4.setDate_fin_contrat(new Date(124,2,1));
        contrat4.setCopie_contrat("copieContrat.pdf");
        contrat4.setEntrepriseClients(new EntrepriseClient(ec4.getId()));
        contrat4.setEtatContrat(false);
        contrat4.setPeriodicite_contrat(new ArrayList<PeriodiciteContrat>(Arrays.asList(PeriodiciteContrat.MENSUELX2)));

        session5.beginTransaction();

        session5.save(contrat);
        session5.save(contrat1);
        session5.save(contrat2);
        session5.save(contrat3);
        session5.save(contrat4);

        session5.getTransaction().commit();
        session5.close();

        //########################>>CREATE Ofrre#################################
        // Initialize Session Object
        Session session4 = sessionFactory.openSession();

        Offre offre = new Offre();
        Offre offre1 = new Offre();
        Offre offre2= new Offre();
        Offre offre3 = new Offre();
        Offre offre4 = new Offre();

        //1
        offre.setLibelle("Karangue");
        offre.setPourcentage(60);
        offre.setContrat(new Contrat(1L));
        offre.setCreateBy(new Agent(1L));

        //2
        offre1.setLibelle("Faggu");
        offre1.setPourcentage(70);
        offre1.setContrat(new Contrat(2L));
        offre1.setCreateBy(new Agent(1L));

        //3
        offre2.setLibelle("Tawfeekh");
        offre2.setPourcentage(80);
        offre2.setContrat(new Contrat(3L));
        offre2.setCreateBy(new Agent(1L));

        //4
        offre3.setLibelle("Noflaye");
        offre3.setPourcentage(90);
        offre3.setContrat(new Contrat(4L));
        offre3.setContrat(new Contrat(5L));
        offre3.setCreateBy(new Agent(1L));

        //5
        offre4.setLibelle("Premium");
        offre4.setPourcentage(100);
        offre4.setContrat(new Contrat(5L));
        offre4.setCreateBy(new Agent(1L));

        session4.beginTransaction();
        // Here we have used
        // update() method of JPA

        session4.save(offre);
        session4.save(offre1);
        session4.save(offre2);
        session4.save(offre3);
        session4.save(offre4);
        session4.getTransaction().commit();
        session4.close();

        //########################>>CREATE SERVICES#################################
        // Initialize Session Object
        Session session6 = sessionFactory.openSession();

        Service service = new Service();
        Service service1 = new Service();
        Service service2= new Service();
        Service service3 = new Service();
        Service service4= new Service();
        Service service5= new Service();
        Service service6= new Service();
        Service service7= new Service();
        Service service8= new Service();
        //Service service9= new Service();

        service.setNomService("URGENTISTE");
        service.setCreateBy(new Agent(1L));
        service.setUpdateBy(1L);

        service1.setNomService("MEDECINE-GENERALE");
        service1.setCreateBy(new Agent(1L));
        service1.setUpdateBy(1L);

        service2.setNomService("DENTISTE");
        service2.setCreateBy(new Agent(1L));
        service2.setUpdateBy(1L);

        service3.setNomService("OPHTALMOLOGIE");
        service3.setCreateBy(new Agent(1L));
        service3.setUpdateBy(1L);

        service4.setNomService("MEDECIN-BIOLOGISTE");
        service4.setCreateBy(new Agent(1L));
        service4.setUpdateBy(1L);

        service5.setNomService("DERMATOLOGIE");
        service5.setCreateBy(new Agent(1L));
        service5.setUpdateBy(1L);

        service6.setNomService("CANCEROLOGIE");
        service6.setCreateBy(new Agent(1L));
        service6.setUpdateBy(1L);

        service7.setNomService("PEDIATRIQUE");
        service7.setCreateBy(new Agent(1L));
        service7.setUpdateBy(1L);

        service8.setNomService("DIABETOLOGIE-ENDOCRINOLOGUE");
        service8.setCreateBy(new Agent(1L));
        service8.setUpdateBy(1L);


        session6.beginTransaction();
        session6.save(service);
        session6.save(service1);
        session6.save(service2);
        session6.save(service3);
        session6.save(service4);
        session6.save(service5);
        session6.save(service6);
        session6.save(service7);
        session6.save(service8);
        //session6.save(service9);
        session6.getTransaction().commit();
        session6.close();

        //########################>>CREATE SERVICES#################################
        // Initialize Session Object
        Session session7 = sessionFactory.openSession();

        //Specialite urgentiste
        Specialite specialite = new Specialite();
        Specialite specialite1 = new Specialite();
        Specialite specialite2 = new Specialite();
        Specialite specialite3 = new Specialite();
        Specialite specialite4 = new Specialite();
        Specialite specialite5 = new Specialite();

        //Specialite medecin generaliste
        Specialite specialite6 = new Specialite();
        Specialite specialite7 = new Specialite();
        Specialite specialite8 = new Specialite();
        Specialite specialite9 = new Specialite();
        Specialite specialite10 = new Specialite();
        //Specialite specialite11 = new Specialite();
        Specialite specialite12 = new Specialite();

        //Specialite medecin dentiste
        Specialite specialite13 = new Specialite();
        Specialite specialite14 = new Specialite();
        Specialite specialite15 = new Specialite();
        Specialite specialite16 = new Specialite();
        Specialite specialite17 = new Specialite();
        Specialite specialite18 = new Specialite();

        //Specialite medecin ophthalmologue
        Specialite specialite19 = new Specialite();
        Specialite specialite20 = new Specialite();
        Specialite specialite21 = new Specialite();
        Specialite specialite22 = new Specialite();
        Specialite specialite23 = new Specialite();
        Specialite specialite24 = new Specialite();

        //Specialite medecin-biologiste
        Specialite specialite25 = new Specialite();
        Specialite specialite26 = new Specialite();
        Specialite specialite27 = new Specialite();
        Specialite specialite28 = new Specialite();
        Specialite specialite29 = new Specialite();
        Specialite specialite30 = new Specialite();

        //Specialite medecin dermatologue
        Specialite specialite31 = new Specialite();
        Specialite specialite32 = new Specialite();
        Specialite specialite33 = new Specialite();
        Specialite specialite34 = new Specialite();
        Specialite specialite35 = new Specialite();
        Specialite specialite36 = new Specialite();

        //Specialite medecin cancerologue
        Specialite specialite37 = new Specialite();
        Specialite specialite38 = new Specialite();
        Specialite specialite39 = new Specialite();
        Specialite specialite40 = new Specialite();
        Specialite specialite41 = new Specialite();
        Specialite specialite42 = new Specialite();

        //Specialite medecin pediatre
        Specialite specialite43 = new Specialite();
        Specialite specialite44 = new Specialite();
        Specialite specialite45 = new Specialite();
        Specialite specialite46 = new Specialite();
        Specialite specialite47 = new Specialite();
        Specialite specialite48 = new Specialite();

        //Specialite medecin diabétologue-endocrinologue
        Specialite specialite49 = new Specialite();
        Specialite specialite50 = new Specialite();
        Specialite specialite51 = new Specialite();
        Specialite specialite52 = new Specialite();
        Specialite specialite53 = new Specialite();
        Specialite specialite54 = new Specialite();

       //Specialite urgentiste
        specialite.setNomSpecialite("MEDECINE-D-URGENCE ");
        specialite1.setNomSpecialite("REANIMATION-MEDICALE");
        specialite2.setNomSpecialite("TRAUMATOLOGIE");
        specialite3.setNomSpecialite("MEDICINE-PREHOSPITALIERE");
        specialite4.setNomSpecialite("TOXICOLOGIE");
        specialite5.setNomSpecialite("URGENCES-PEDIATRIQUE");

        //Specialite medecine generaliste
        specialite6.setNomSpecialite("MEDECINE-INTERNE");
        specialite7.setNomSpecialite("GYNECOLOGIE-OBSTETRIQUE");
        specialite8.setNomSpecialite("PEDIATRIQUE");
        specialite9.setNomSpecialite("MEDECINE-PREVENTIVE-DEPISTAGE");
        specialite10.setNomSpecialite("SANTE-MENTALE");
       // specialite11.setNomSpecialite("MEDECINE-PREVENTIVE & DEPISTAGE");
        specialite12.setNomSpecialite("SOINS-PALLIATIFS");

        //Specialite medecine dentiste
        specialite13.setNomSpecialite("DENTISTERIE-GENERALE");
        specialite14.setNomSpecialite("ORTHODONTIE");
        specialite15.setNomSpecialite("CHIRURGIE-BUCCALE & MAXILLO-FACIALE");
        specialite16.setNomSpecialite("ENDODONTIE");
        specialite17.setNomSpecialite("PARODONTIE");
        specialite18.setNomSpecialite("PROSTHODONTIE ");

        //Specialite medecine Ophthalmologiste
        specialite19.setNomSpecialite("OPHTALMOLOGIE-GENERALE");
        specialite20.setNomSpecialite("CHIRURGIE-DE-LA-CATARACTE");
        specialite21.setNomSpecialite("CHIRURGIE-REFRACTIVE");
        specialite22.setNomSpecialite("RETINE & VITRÉ");
        specialite23.setNomSpecialite("OPHTALMOLOGIE-PEDIATRIQUE");
        specialite24.setNomSpecialite("OPHTALMOLOGIE-MEDICALE");

        //Specialite MEDECIN-BIOLOGISTE
        specialite25.setNomSpecialite("PATHOLOGIE");
        specialite26.setNomSpecialite("MICROBIOLOGIE-MEDICALE");
        specialite27.setNomSpecialite("IMMUNOLOGIE");
        specialite28.setNomSpecialite("BIOCHIMIE-CLINIQUE");
        specialite29.setNomSpecialite("GENETIQUE-MEDICALE");
        specialite30.setNomSpecialite("TOXICOLOGIE");

        //Specialite medecin dermatologue
        specialite31.setNomSpecialite("DERMATOLOGIE-GENERALE");
        specialite32.setNomSpecialite("DERMATOLOGIE-ESTHETIQUE");
        specialite33.setNomSpecialite("DERMATOLOGIE-PEDIATRIQUE");
        specialite34.setNomSpecialite("DERMATOLOGIE-CHIRURGICAUX");
        specialite35.setNomSpecialite("DERMATOLOGIE-ONCOLOGIQUE");
        specialite36.setNomSpecialite("DERMATOLOGIE-ALLERGIQUE & IMMUNOLOGIQUE");

        //Specialite medecin cancerologue
        specialite37.setNomSpecialite("ONCOLOGIE-MEDICALE");
        specialite38.setNomSpecialite("RADIOTHERAPIE-ONCOLOGIQUE");
        specialite39.setNomSpecialite("CHIRURGIE-ONCOLOGIQUE");
        specialite40.setNomSpecialite("ONCOLOGIE-PEDIATRIQUE");
        specialite41.setNomSpecialite("GENETIQUE-ONCOLOGIQUE");
        specialite42.setNomSpecialite("SOINS-DE-SUPPORTS-EN-ONCOLOGIE");

        //Specialite medecin pediatre
        specialite43.setNomSpecialite("PEDIATRIE-GENERALE");
        specialite44.setNomSpecialite("PEDIATRIE-NEONATALE");
        specialite45.setNomSpecialite("PEDIATRIE-DU-DEVELOPPEMENT");
        specialite46.setNomSpecialite("PEDIATRIE-CARDIAQUE");
        specialite47.setNomSpecialite("PEDIATRIE-GASTROENTEROLOGIQUE");
        specialite48.setNomSpecialite("PEDIATRIE-PULMONAIRE");

        //Specialite medecin diabétologue-endocrinologue
        specialite49.setNomSpecialite("DIABETOLOGIE");
        specialite50.setNomSpecialite("ENDOCRINOLOGIE-GENERALE");
        specialite51.setNomSpecialite("ENDOCRINOLOGIE-PEDIATRIQUE");
        specialite52.setNomSpecialite("ENDOCRINOLOGIE-REPRODUCTIVE");
        specialite53.setNomSpecialite("ENDOCRINOLOGIE-OSSEUSE");
        specialite54.setNomSpecialite("ENDOCRINOLOGIE-ONCOLOGIQUE");


        session7.beginTransaction();
        session7.save(specialite);
        session7.save(specialite1);
        session7.save(specialite2);
        session7.save(specialite3);
        session7.save(specialite4);
        session7.save(specialite5);

        session7.save(specialite6);
        session7.save(specialite7);
        session7.save(specialite8);
        session7.save(specialite9);
        session7.save(specialite10);
        //session7.save(specialite11);
        session7.save(specialite12);

        session7.save(specialite13);
        session7.save(specialite14);
        session7.save(specialite15);
        session7.save(specialite16);
        session7.save(specialite17);
        session7.save(specialite18);

        session7.save(specialite19);
        session7.save(specialite20);
        session7.save(specialite21);
        session7.save(specialite22);
        session7.save(specialite23);
        session7.save(specialite24);

        session7.save(specialite25);
        session7.save(specialite26);
        session7.save(specialite27);
        session7.save(specialite28);
        session7.save(specialite29);
        session7.save(specialite30);

        session7.save(specialite31);
        session7.save(specialite32);
        session7.save(specialite33);
        session7.save(specialite34);
        session7.save(specialite35);
        session7.save(specialite36);

        session7.save(specialite37);
        session7.save(specialite38);
        session7.save(specialite39);
        session7.save(specialite40);
        session7.save(specialite41);
        session7.save(specialite42);

        session7.save(specialite43);
        session7.save(specialite44);
        session7.save(specialite45);
        session7.save(specialite46);
        session7.save(specialite47);
        session7.save(specialite48);

        session7.save(specialite49);
        session7.save(specialite50);
        session7.save(specialite51);
        session7.save(specialite52);
        session7.save(specialite53);
        session7.save(specialite54);

        session7.getTransaction().commit();
        session7.close();

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
        um.setEmail("mba25116@gmail.com");
        um.setTel("783703310");
        um.setUserIdd("RIDCA-83223760");
        um.setAdresse("Kounoune");
        um.setLieuNaiss("Malika");
        um.setCreateBy(new Agent(1L));
        um.setEntrepriseClients(new EntrepriseClient(5L));
        um.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
       // um.setCreateBy(um.getAgent().getId());
        um.setUpdateBy(um.getCreateBy().getId());

        //1
        um1.setNom("Mane");
        um1.setPrenom("Seydou");
        um1.setGenre("Masculin");
        um1.setEmail("seydou-mane@gmail.com");
        um1.setTel("701773310");
        um1.setUserIdd("RIDCA-62185408");
        um1.setAdresse("Diamagueune");
        um1.setLieuNaiss("Dakar");
        um1.setCreateBy(new Agent(2L));
        um1.setEntrepriseClients(new EntrepriseClient(4L));
        um1.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
       // um1.setCreateBy(um1.get().getId());
        um1.setUpdateBy(um1.getCreateBy().getId());

        //2
        um2.setNom("Dieng");
        um2.setPrenom("Haby");
        um2.setGenre("Feminin");
        um2.setEmail("habydieng@gmail.com");
        um2.setTel("779703310");
        um2.setUserIdd("RIDCA-62185308");
        um2.setAdresse("Diaxaaye");
        um2.setLieuNaiss("Dakar");
        um2.setCreateBy(new Agent(3L));
        um2.setEntrepriseClients(new EntrepriseClient(3L));
        um2.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        //um2.setCreateBy(um2.getAgent().getId());
        um2.setUpdateBy(um2.getCreateBy().getId());

        //3
        um3.setNom("Ndiaye");
        um3.setPrenom("Serigne Modou");
        um3.setGenre("Masculin");
        um3.setEmail("modoundiaye@gmail.com");
        um3.setTel("778703310");
        um3.setUserIdd("RIDCA-69979028");
        um3.setAdresse("Diaxaaye");
        um3.setLieuNaiss("Dakar");
        um3.setCreateBy(new Agent(4L));
        um3.setEntrepriseClients(new EntrepriseClient(2L));
        um3.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
     //   um3.setCreateBy(um3.getAgent().getId());
        um3.setUpdateBy(um3.getCreateBy().getId());

        //4
        um4.setNom("Diop");
        um4.setPrenom("Awa");
        um4.setGenre("Feminin");
        um4.setEmail("diop-awa@gmail.com");
        um4.setTel("709703310");
        um4.setUserIdd("RIDCA-76245138");
        um4.setAdresse("Pikine");
        um4.setLieuNaiss("Pikine");
        um4.setCreateBy(new Agent(5L));
        um4.setEntrepriseClients(new EntrepriseClient(1L));
        um4.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        //um4.setCreateBy(um4.getAgent().getId());
        um4.setUpdateBy(um4.getCreateBy().getId());

        //5
        um5.setNom("Mangane");
        um5.setPrenom("Abdoulahi");
        um5.setGenre("Masculin");
        um5.setEmail("abmangane14@gmail.com");
        um5.setTel("754703310");
        um5.setUserIdd("RIDCA-29660708");
        um5.setAdresse("Keur Massar");
        um5.setLieuNaiss("Kaolack");
        um5.setCreateBy(new Agent(3L));
        um5.setEntrepriseClients(new EntrepriseClient(5L));
        um5.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        //um5.setCreateBy(um5.getAgent().getId());
        um5.setUpdateBy(um5.getCreateBy().getId());

        //6
        um6.setNom("Diop");
        um6.setPrenom("Fama Zeyna Faye");
        um6.setGenre("Feminin");
        um6.setEmail("fzfd@gmail.com");
        um6.setTel("762703310");
        um6.setUserIdd("RIDCA-42506205");
        um6.setAdresse("Parcelles Assainies");
        um6.setLieuNaiss("Parcelles Assainies U-26");
        um6.setCreateBy(new Agent(2L));
        um6.setEntrepriseClients(new EntrepriseClient(3L));
        um6.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
       // um6.setCreateBy(um6.getAgent().getId());
        um6.setUpdateBy(um6.getCreateBy().getId());
        um6.setEtat(false);

        //7
        um7.setNom("Diouf");
        um7.setPrenom("Serigne Mor");
        um7.setGenre("Masculin");
        um7.setEmail("diouf-mor@gmail.com");
        um7.setTel("781705312");
        um7.setUserIdd("RIDCA-67981493");
        um7.setAdresse("Darou Khoudoss");
        um7.setLieuNaiss("Gouye Kouli");
        um7.setCreateBy(new Agent(3L));
        um7.setEntrepriseClients(new EntrepriseClient(2L));
        um7.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
       // um7.setCreateBy(um7.getAgent().getId());
        um7.setUpdateBy(um7.getCreateBy().getId());
        um7.setEtat(false);

        //8
        um8.setNom("Diallo");
        um8.setPrenom("Souleymane");
        um8.setGenre("Masculin");
        um8.setEmail("diallo-souleymane@gmail.com");
        um8.setTel("770703310");
        um8.setUserIdd("RIDCA-72552138");
        um8.setAdresse("Keur Massar");
        um8.setLieuNaiss("Medina");
        um8.setCreateBy(new Agent(5L));
        um8.setEntrepriseClients(new EntrepriseClient(4L));
        um8.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        //um8.setCreateBy(um8.getAgent().getId());
        um8.setUpdateBy(um8.getCreateBy().getId());
        um8.setEtat(false);

        //9
        um9.setNom("Niang");
        um9.setPrenom("Oumy");
        um9.setGenre("Feminin");
        um9.setEmail("niang-oumy@gmail.com");
        um9.setTel("770700010");
        um9.setUserIdd("RIDCA-62236195");
        um9.setAdresse("Dakar");
        um9.setLieuNaiss("Dakar");
        um9.setCreateBy(new Agent(4L));
        um9.setEntrepriseClients(new EntrepriseClient(5L));
        um9.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
       // um9.setCreateBy(um9.getAgent().getId());
        um9.setUpdateBy(um9.getCreateBy().getId());
        um9.setEtat(false);

        //9
        um10.setNom("Diouf");
        um10.setPrenom("Mame Birame");
        um10.setGenre("Masculin");
        um10.setEmail("diouf-birame@gmail.com");
        um10.setTel("760700010");
        um10.setUserIdd("RIDCA-67997700");
        um10.setAdresse("Sebikotane");
        um10.setLieuNaiss("Sebikotane");
        um10.setCreateBy(new Agent(3L));
        um10.setEntrepriseClients(new EntrepriseClient(1L));
        um10.setRoles(new ArrayList<Role>(Arrays.asList(Role.ADHERENT)));
        //um10.setCreateBy(um10.getAgent().getId());
        um10.setUpdateBy(um10.getCreateBy().getId());
        um10.setEtat(false);

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
