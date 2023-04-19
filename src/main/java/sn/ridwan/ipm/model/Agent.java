package sn.ridwan.ipm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name = "AGENTS")
public class Agent extends User implements Serializable {

    @NotBlank
    @Column
    private String fonction;
    @NotBlank
    @Column
    private String conventionCollective;

    @NotBlank
    @Column
    private String categorie;
    @NotBlank
    @Column
    private String ancienete;
    @NotBlank
    @Column
    private String adresse;

    public Agent() {
    }

    public Agent(Long id, String nom, String prenom, String genre, boolean isEtat, String email, String numTelephone, String ipmId, String password, String fonction, String conventionCollective, String categorie, String ancienete, String adresse) {
        super(id, nom, prenom, genre, isEtat, email, numTelephone, ipmId, password);
        this.fonction = fonction;
        this.conventionCollective = conventionCollective;
        this.categorie = categorie;
        this.ancienete = ancienete;
        this.adresse = adresse;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getConventionCollective() {
        return conventionCollective;
    }

    public void setConventionCollective(String conventionCollective) {
        this.conventionCollective = conventionCollective;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAncienete() {
        return ancienete;
    }

    public void setAncienete(String ancienete) {
        this.ancienete = ancienete;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
