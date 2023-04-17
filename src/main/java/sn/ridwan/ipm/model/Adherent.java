package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="ADHERENTS")
public class Adherent  extends  User{
    @Column
    private String adresse;
    @Column
    private Date dateNaiss;
    @Column
    private String lieuNaiss;
    public Adherent() {
    }

    public Adherent(String adresse, Date dateNaiss, String lieuNaiss) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    public Adherent(Long id, String nom, String prenom, String genre, boolean isEtat, String email, String numTelephone, String ipmId, String password, String role, String adresse, Date dateNaiss, String lieuNaiss) {
        super(id, nom, prenom, genre, isEtat, email, numTelephone, ipmId, password, role);
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

    @Override
    public String toString() {
        return "Adherent{" +
                "adresse='" + adresse + '\'' +
                ", dateNaiss=" + dateNaiss +
                ", lieuNaiss='" + lieuNaiss + '\'' +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", isEtat=" + isEtat +
                ", email='" + email + '\'' +
                ", numTelephone='" + numTelephone + '\'' +
                ", ipmId='" + ipmId + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
