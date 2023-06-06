package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="ADHERENTS")
@NamedQuery(name = "Adherent.findAll", query = "SELECT ad FROM Adherent ad")
public class Adherent extends User{
    @Column
    private String adresse;
    @Column
    @CreationTimestamp
    private Date dateNaiss ;
    @Column
    private String lieuNaiss;

  /*  @Column(name = "ad_email",unique = true)
    //@Pattern(regexp = "^(.+)@(.+)$")
    private String ad_email;
    @Column(name = "ad_tel", unique=true)
    // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    private String ad_tel;

    @Column(name = "IpmID", unique=true)
    // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    private String IpmID;*/
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="agent_id",referencedColumnName = "id",nullable = true)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="entrepriseClients_id",referencedColumnName = "id",nullable = true)
    private EntrepriseClient entrepriseClients;

    public Adherent(Long id) {
        super(id);
    }

    public Adherent(String adresse, Date dateNaiss, String lieuNaiss) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }


    public Adherent(String nom, String prenom, String genre, String userIdd, String tel,String email, ArrayList<Role> roles, String image, String adresse, Date dateNaiss, String lieuNaiss) {
        super(nom, prenom, genre, userIdd, tel,email, roles, image);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
    }
}
