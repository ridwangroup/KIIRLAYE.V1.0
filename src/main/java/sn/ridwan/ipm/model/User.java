package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import sn.ridwan.ipm.services.implement.userImplement;
import sn.ridwan.security.log.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import static sn.ridwan.security.helpers.ValidatorHelper.HashPlainPassword;
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "User.findAll", query = "SELECT us FROM User us WHERE us.isEtat=true")
@Log
public class User extends userImplement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String genre;
    @Column
    private boolean isEtat = true;
    @Column(name = "password")
    private String password = HashPlainPassword("passer");
    @Transient
    private String login="";
    @Transient
    private String token="";
    @Column(name = "userIdd",unique=true)
    private String userIdd;
    @Column(name = "telephone",unique=true)
    private String tel;
    @Column(name = "email",unique=true)
    private String email;
    @Column
    private boolean firstConnection=false;
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private ArrayList<Role> roles;
    @Column
    private String image = "https://www.w3schools.com/howto/img_avatar.png";
    @Column(updatable=false,nullable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date updatedAt;
 /*   @Column(name="createBy",updatable=false,nullable = false)
    private Long createBy;*/
    @Column(name="updateBy")
    private Long updateBy;
    @Column
    private boolean isConnect = false;

    public User(Long id) {
        this.id=id;
    }
    public User(String nom, String prenom, String genre, String userIdd, String tel,String email, ArrayList<Role> roles, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.tel = tel;
        this.email= email;
        this.roles = roles;
        this.image = image;
    }

}
