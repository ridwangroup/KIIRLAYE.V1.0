package sn.ridwan.ipm.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Adherent extends User{

    private String adresse;
    private Date dateNaiss;
    private String lieuNaiss;

    public Adherent(String nom, String prenom, String genre, boolean isEtat, String email, String numTelephone, String ipmId, String password, String adresse, Date dateNaiss, String lieuNaiss) {
        super(nom, prenom, genre, isEtat, email, numTelephone, ipmId, password);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    public Adherent(){

    }

    public Adherent(String adresse, Date dateNaiss, String lieuNaiss) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    public Adherent(String email, String numTelephone, String ipmId, String password, String adresse, Date dateNaiss, String lieuNaiss) {
        super(email, numTelephone, ipmId, password);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }


}
