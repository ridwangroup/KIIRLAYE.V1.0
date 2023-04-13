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
    public Adherent(String adresse, Date dateNaiss, String lieuNaiss) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }

    public Adherent() {
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
