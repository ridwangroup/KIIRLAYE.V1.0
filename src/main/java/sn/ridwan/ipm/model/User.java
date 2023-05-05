package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import sn.ridwan.ipm.Service_ipm_impl.userImplement;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
//@AllArgsConstructor
@ToString
//@Getter
//@Setter
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "User.findAll", query = "SELECT us FROM User us")
public class User extends userImplement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 /*   @Transient
    private String dv= "+221";*/
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String genre;
    @Column
    private boolean isEtat = true;

    @Column(name = "userIdd",unique=true)
    private String userIdd;
    @Column(name = "password")
    private String password =  checkPassword("passer");;
    @Transient
    private String login="";
    @Column
    private String tel;
    @Column
    private String role;
    @Column
    private String image = "https://www.w3schools.com/howto/img_avatar.png";

    @Column
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

    public User(Long id) {
        this.id=id;
    }

    public User(String nom, String prenom, String genre,String userIdd, String role,String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.role = role;
        this.tel=tel;
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

    public String getUserIdd() {
        return userIdd;
    }

    public void setUserIdd(String userIdd) {
        this.userIdd = userIdd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = "+221_"+tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
