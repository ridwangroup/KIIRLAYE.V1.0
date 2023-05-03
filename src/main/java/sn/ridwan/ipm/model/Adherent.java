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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="agent_id",referencedColumnName = "id",nullable = true)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="entrepriseClients_id",referencedColumnName = "id",nullable = true)
    private EntrepriseClient entrepriseClients;


    public Adherent(Long id) {
        super(id);
    }


    public Adherent(String adresse, String lieuNaiss, Agent agent_id, EntrepriseClient entrepriseClients) {
        this.adresse = adresse;
        this.lieuNaiss = lieuNaiss;
        this.agent = agent_id;
        this.entrepriseClients = entrepriseClients;
    }


    public Adherent(String nom, String prenom, String genre, String email, String numTelephone, String userIdd, String role, String adresse, String lieuNaiss, Agent agent, EntrepriseClient entrepriseClients) {
        super(nom, prenom, genre, email, numTelephone, userIdd, role);
        this.adresse = adresse;
        this.lieuNaiss = lieuNaiss;
        this.agent = agent;
        this.entrepriseClients = entrepriseClients;
    }

}
