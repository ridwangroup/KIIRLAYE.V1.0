package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

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
    @Column(name = "ipmid",unique=true)
    protected String ipmId;
    @Column(name = "password")
    protected String password;
    @Column
    protected String role;
    //@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    //@Column
    //protected List<String> roles;
}
