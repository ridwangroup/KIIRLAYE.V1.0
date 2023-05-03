package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(name = "SimpleEmail",unique = true)
    //@Pattern(regexp = "^(.+)@(.+)$")
    private String email;
    @Column(name = "SimpleNum", unique=true)
    // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    private String Telephone;

    @Column(name = "IpmID", unique=true)
    // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    private String IpmID;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="agent_id",referencedColumnName = "id",nullable = true)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="entrepriseClients_id",referencedColumnName = "id",nullable = true)
    private EntrepriseClient entrepriseClients;


    public Adherent(Long id) {
        super(id);
    }

    public Adherent(String adresse, Date dateNaiss, String lieuNaiss, String email, String telephone,String ipmID) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.email = email;
        this.Telephone = telephone;
        this.IpmID = ipmID;
    }

    public Adherent(String nom, String prenom, String genre, String userIdd, String role, String adresse, Date dateNaiss, String lieuNaiss, String email, String telephone,String ipmID) {
        super(nom, prenom, genre, userIdd, role);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.email = email;
        Telephone = telephone;
        this.IpmID = ipmID;
    }
}
