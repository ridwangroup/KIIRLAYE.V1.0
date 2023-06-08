package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "ENTREPRISE_CLIENTS")
@NamedQuery(name = "EntrepriseClient.findAll", query = "SELECT ec FROM EntrepriseClient ec")
@NamedQuery(name = "EntrepriseClientActif.findAll", query = "SELECT ec FROM EntrepriseClient ec WHERE ec.etatEntreprise=true")
@NamedQuery(name = "EntrepriseClientInActif.findAll", query = "SELECT ec FROM EntrepriseClient ec WHERE ec.etatEntreprise=false")

public class EntrepriseClient extends Entreprise {
    @Column(updatable=false,nullable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name="updateBy")
    private Long updateBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="adresse_id",referencedColumnName = "id",nullable = true)
    private Adresse adresse;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="createBy",referencedColumnName = "id",updatable=false,nullable = false)
    private Agent createBy;

    @OneToMany(mappedBy = "entrepriseClients", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Adherent> adherent;

    public EntrepriseClient(Long id) {
        super(id);
    }

    public EntrepriseClient(Date createdAt, Date updatedAt, Long updateBy, Adresse adresse, Agent createBy) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.updateBy = updateBy;
        this.adresse = adresse;
        this.createBy = createBy;
    }

    public EntrepriseClient(String nomEntreprise, String ninea, String numRegCommerce, String numeroTelephone, String emailEntreprise, String logo, String fax, boolean etatEntreprise, Date createdAt, Date updatedAt, Long updateBy, Adresse adresse, Agent createBy) {
        super(nomEntreprise, ninea, numRegCommerce, numeroTelephone, emailEntreprise, logo, fax, etatEntreprise);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.updateBy = updateBy;
        this.adresse = adresse;
        this.createBy = createBy;
    }
}
