package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "PERSONNES")
public abstract class Personne  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String nom;
    @Column
    protected String prenom;

    @Column
    protected String genre;

    @Column
    protected boolean isEtat;

    public Personne() {
    }

    public Personne(String nom, String prenom, String genre, boolean isEtat) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.isEtat = isEtat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isEtat() {
        return isEtat;
    }

    public void setEtat(boolean etat) {
        isEtat = etat;
    }
}

