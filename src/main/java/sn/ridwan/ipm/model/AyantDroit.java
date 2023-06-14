package sn.ridwan.ipm.model;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class AyantDroit {
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNais;
    private String lieuDeNais;
    private String sexe;
    private String status;
    @ManyToOne
    private Adherent adherent;

    public AyantDroit() {
    }

    public AyantDroit(String nom, String prenom, LocalDate dateDeNais, String lieuDeNais, String sexe, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNais = dateDeNais;
        this.lieuDeNais = lieuDeNais;
        this.sexe = sexe;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNais() {
        return dateDeNais;
    }

    public void setDateDeNais(LocalDate dateDeNais) {
        this.dateDeNais = dateDeNais;
    }

    public String getLieuDeNais() {
        return lieuDeNais;
    }

    public void setLieuDeNais(String lieuDeNais) {
        this.lieuDeNais = lieuDeNais;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
