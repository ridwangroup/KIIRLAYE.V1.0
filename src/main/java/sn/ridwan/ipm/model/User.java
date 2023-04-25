package sn.ridwan.ipm.model;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Random;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "USERS")
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
    @Column(unique = true)
    //@Pattern(regexp = "^(.+)@(.+)$")
    protected String email;
    @Column(name = "numeroTelephone", unique=true)
   // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    protected String numTelephone;
    @Column(name = "userIdd",unique=true)
    protected String userIdd;
    @Column(name = "password")
    protected String password =  checkPassword("passer");;
    @Column(name = "login")
    protected String login="";
    @Column
    protected String role;

    public String checkPassword(String plainPassword) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        //System.out.println(bcryptHashString);
        return bcryptHashString;
    }




}
