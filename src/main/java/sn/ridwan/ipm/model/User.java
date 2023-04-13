package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

@Entity
@Table(name = "Users")
public class User extends Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long id_users;
    @Column(name="email", unique = true)
    @Pattern(regexp = "^(.+)@(.+)$")
    protected String email;

    @Column(name = "numeroTelephone", unique=true)
    @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    protected String numTelephone;

    @Column(name = "ipmid",unique=true)
    protected String ipmId;

    @Column(name = "password")
    protected String password;

    public User() {
    }

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
