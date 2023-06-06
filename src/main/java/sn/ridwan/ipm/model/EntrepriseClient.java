package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
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
public class EntrepriseClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String nomEntreprise;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String ninea;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String numRegCommerce;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String numeroTelephone;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String emailEntreprise;

    //@NotEmpty(message = "Ce champ est obligatoire")
    @Column
    //private byte[] logo;
    private String logo = "https://www.w3schools.com/howto/img_avatar.png";

    @Column
    private String fax;

    @Column
    private boolean isEtat = true;
    @Column(updatable=false,nullable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date updatedAt;
   /* @Column(name="createAtBy",updatable=false,nullable = false)
    private Long createAtBy;*/
    @Column(name="updateAtBy")
    private Long updateAtBy;

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
        this.id = id;
    }

    public EntrepriseClient(String nomEntreprise, String ninea, String numRegCommerce, String numeroTelephone, String emailEntreprise, @NotEmpty(message = "Ce champ est obligatoire") String logo, Date createdAt, Date updatedAt, Adresse adresse, Agent createBy, List<Adherent> adherent) {
        this.nomEntreprise = nomEntreprise;
        this.ninea = ninea;
        this.numRegCommerce = numRegCommerce;
        this.numeroTelephone =  numeroTelephone;
        this.emailEntreprise = emailEntreprise;
        this.adresse = adresse;
        this.createBy = createBy;
    }

}
