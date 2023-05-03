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
@Getter
@Setter
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "User.findAll", query = "SELECT us FROM User us")
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

    @Column(name = "userIdd",unique=true)
    private String userIdd;
    @Column(name = "password")
    private String password =  checkPassword("passer");;
    @Transient
    private String login="";
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

    public User(String nom, String prenom, String genre,String userIdd, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.role = role;

    }
}
