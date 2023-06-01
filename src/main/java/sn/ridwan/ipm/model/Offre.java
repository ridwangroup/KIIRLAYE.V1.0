package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@NamedQuery(name = "Offre.findAll", query = "SELECT offre FROM Offre offre")
public class Offre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean etatOffre = true;

    @Column
    private String libelle;

    @Column
    private Integer pourcentage;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="contrat_id",referencedColumnName = "id",nullable = true)
    private Contrat contrat;

    public Offre(String libelle, Integer pourcentage, Contrat contrat) {
        this.libelle = libelle;
        this.pourcentage = pourcentage;
        this.contrat = contrat;
    }

}
