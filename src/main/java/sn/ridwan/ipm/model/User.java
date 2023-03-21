package sn.ridwan.ipm.model;

import jakarta.persistence.Entity;

@Entity
public abstract class User extends  Personne{

    private String email;
    private String numTelephone;
    private String ipmId;
    private String password;

    public User(String nom, String prenom, String genre, boolean isEtat, String email, String numTelephone, String ipmId, String password) {
        super(nom, prenom, genre, isEtat);
        this.email = email;
        this.numTelephone = numTelephone;
        this.ipmId = ipmId;
        this.password = password;
    }

    public User(){}

    public User(String email, String numTelephone, String ipmId, String password) {
        this.email = email;
        this.numTelephone = numTelephone;
        this.ipmId = ipmId;
        this.password = password;
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



}
