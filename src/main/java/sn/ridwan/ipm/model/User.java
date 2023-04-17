package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User implements Serializable {
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
    @Column(name="email", unique = true)
    //@Pattern(regexp = "^(.+)@(.+)$")
    protected String email;
    @Column(name = "numeroTelephone", unique=true)
   // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    protected String numTelephone;
    @Column(name = "ipmid",unique=true)
    protected String ipmId;
    @Column(name = "password")
    protected String password;

    public User() {
    }

    public User(Long id, String nom, String prenom, String genre, boolean isEtat, String email, String numTelephone, String ipmId, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.isEtat = isEtat;
        this.email = email;
        this.numTelephone = numTelephone;
        this.ipmId = ipmId;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getIpmId() {
        return ipmId;
    }

    public void setIpmId(String ipmId) {
        this.ipmId = ipmId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", isEtat=" + isEtat +
                ", email='" + email + '\'' +
                ", numTelephone='" + numTelephone + '\'' +
                ", ipmId='" + ipmId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
