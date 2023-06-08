package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@NamedQuery(name = "Contrat.findAll", query = "SELECT contrat FROM Contrat contrat")
@NamedQuery(name = "ContratActif.findAll", query = "SELECT contrat FROM Contrat contrat WHERE contrat.etatContrat=true")
@NamedQuery(name = "ContratInActif.findAll", query = "SELECT contrat FROM Contrat contrat WHERE contrat.etatContrat=false")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean etatContrat = true;
    @Column
    private Date date_signature;

    @Column
    private Date date_entree_vigueur;

    @Column
    private Date date_fin_contrat;

    @Column
    private String copie_contrat;

    @Enumerated(EnumType.STRING)
    @Column
    private ArrayList<PeriodiciteContrat> periodicite_contrat;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="entrepriseClients_id",referencedColumnName = "id",nullable = true)
    private EntrepriseClient entrepriseClients;

    @OneToMany(mappedBy = "contrat", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Offre> offre;

    public Contrat(Date date_signature, Date date_entree_vigueur, Date date_fin_contrat, String copie_contrat, ArrayList<PeriodiciteContrat> periodicite_contrat, EntrepriseClient entrepriseClients, List<Offre> offre) {
        this.date_signature = date_signature;
        this.date_entree_vigueur = date_entree_vigueur;
        this.date_fin_contrat = date_fin_contrat;
        this.copie_contrat = copie_contrat;
        this.periodicite_contrat = periodicite_contrat;
        this.entrepriseClients = entrepriseClients;
        this.offre = offre;

    }

    public Contrat(Long id) {
        this.id = id;
    }
/*  public Contrat(Date date_signature, Date date_entree_vigueur, Date date_fin_contrat, String copie_contrat, ArrayList<PeriodiciteContrat> periodicite_contrat) {
        this.date_signature = date_signature;
        this.date_entree_vigueur = date_entree_vigueur;
        this.date_fin_contrat = date_fin_contrat;
        this.copie_contrat = copie_contrat;
        this.periodicite_contrat = periodicite_contrat;
    }*/



}
