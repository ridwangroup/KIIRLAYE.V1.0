package sn.ridwan.ipm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRATICIENS")
public class Praticien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String matricule;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private boolean etatPraticien;

    public Praticien() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEtatPraticien() {
        return etatPraticien;
    }

    public void setEtatPraticien(boolean etatPraticien) {
        this.etatPraticien = etatPraticien;
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "praticien_id"),
            inverseJoinColumns = @JoinColumn(name = "specialite_id"))
    private List<Specialite> specialiteList;
}
