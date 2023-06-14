package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import sn.ridwan.ipm.model.lettreMedicale.Devis;
import sn.ridwan.ipm.model.lettreMedicale.LettreDeGarentie;
import sn.ridwan.ipm.model.lettreMedicale.LetterDePriseEnChargeMedical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="ADHERENTS")
@NamedQuery(name = "Adherent.findAll", query = "SELECT ad FROM Adherent ad")
@NamedQuery(name = "AdherentActif.findAll", query = "SELECT ad FROM Adherent ad WHERE ad.isEtat=true")
@NamedQuery(name = "AdherentInActif.findAll", query = "SELECT ad FROM Adherent ad WHERE ad.isEtat=false")
public class Adherent extends User{
    @Column
    private String adresse;
    @Column
    @CreationTimestamp
    private Date dateNaiss ;
    @Column
    private String lieuNaiss;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="createBy",referencedColumnName = "id",updatable=false,nullable = false)
    private Agent createBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="entrepriseClients_id",referencedColumnName = "id",nullable = true)
    private EntrepriseClient entrepriseClients;
    @OneToMany
    @JoinColumn(name = "adherent_id",referencedColumnName = "id",updatable = false,nullable = false)
    private List<AyantDroit> ayantDroits;
    @OneToMany
    @JoinColumn(name = "adherent_id",referencedColumnName = "id",updatable = false,nullable = false)
    private List<Devis> devis;
    @OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "lettreDePriseCharge_id",referencedColumnName = "id",updatable = false,nullable = false)
    private List<LetterDePriseEnChargeMedical> lettreDePriseEnCharges;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "lettreDeGarentie_id", referencedColumnName = "id")
    private List<LettreDeGarentie> lettreDeGarenties;

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
