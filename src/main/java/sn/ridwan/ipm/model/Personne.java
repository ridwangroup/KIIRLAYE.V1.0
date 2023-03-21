package sn.ridwan.ipm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public abstract class Personne {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String prenom;
    private String genre;
    private boolean isEtat;

    public Personne(String nom, String prenom, String genre, boolean isEtat) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.isEtat = isEtat;
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

    public Personne() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
