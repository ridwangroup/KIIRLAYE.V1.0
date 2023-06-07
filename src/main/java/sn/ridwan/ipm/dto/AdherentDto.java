package sn.ridwan.ipm.dto;

import lombok.Data;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.EntrepriseClient;
import sn.ridwan.ipm.model.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.Adherent} entity
 */
@Data
public class AdherentDto  {
   // private final String nom;
    //private final String prenom;
   // private final String genre;
   // private final String userIdd;
    //private final String tel;
   // private final String email;
   // private final ArrayList<Role> roles;
    //private final String image;
    private final String adresse;
    private final Date dateNaiss;
    private final String lieuNaiss;
   // private final Agent agent;
    //private final EntrepriseClient entrepriseClients;

    //, Agent agent, EntrepriseClient entrepriseClients
    /*public AdherentDto(String nom, String prenom, String genre, String userIdd, String tel, String email, ArrayList<Role> roles, String image, String adresse, Date dateNaiss, String lieuNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.tel = tel;
        this.email = email;
        this.roles = roles;
        this.image = image;
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        //this.agent = agent;
        //this.entrepriseClients = entrepriseClients;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGenre() {
        return genre;
    }

    public String getUserIdd() {
        return userIdd;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public String getImage() {
        return image;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }*/

/*    public Agent getAgent() {
        return agent;
    }

    public EntrepriseClient getEntrepriseClients() {
        return entrepriseClients;
    }*/
}