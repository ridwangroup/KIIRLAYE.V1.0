package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "STRUCTURES_SANITAIRES")
@NamedQuery(name = "SS.findAll", query = "SELECT ss FROM StructureSanitaire ss WHERE ss.etatEntreprise=true")
public class StructureSanitaire extends Entreprise {
    @Column(updatable=false,nullable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name="updateBy")
    private Long updateBy;
    @Enumerated(EnumType.STRING)
    @Column
    private ArrayList<Plateau_Medical> plateauMedical;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="adresse_id",referencedColumnName = "id",nullable = true)
    private Adresse adresse;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="createBy",referencedColumnName = "id",updatable=false,nullable = false)
    private Agent createBy;

    @OneToMany(mappedBy = "structureSanitaire", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Services_StructuresSanitaires> servicesStructuresSanitairesList;

    public StructureSanitaire(Date createdAt, Date updatedAt, Agent createBy, Long updateBy, ArrayList<Plateau_Medical> plateauMedical, Adresse adresse) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.plateauMedical = plateauMedical;
        this.adresse = adresse;
    }

    public StructureSanitaire(String nomEntreprise, String ninea, String numRegCommerce, String numeroTelephone, String emailEntreprise, String logo, String fax, boolean etatEntreprise, Date createdAt, Date updatedAt, Agent createBy, Long updateBy, ArrayList<Plateau_Medical> plateauMedical, Adresse adresse) {
        super(nomEntreprise, ninea, numRegCommerce, numeroTelephone, emailEntreprise, logo, fax, etatEntreprise);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.plateauMedical = plateauMedical;
        this.adresse = adresse;
    }

    public StructureSanitaire(Long id, Date createdAt, Date updatedAt, Agent createBy, Long updateBy, ArrayList<Plateau_Medical> plateauMedical, Adresse adresse) {
        super(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.plateauMedical = plateauMedical;
        this.adresse = adresse;
    }
}
