package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.List;



@ToString
@Getter
@Setter
@Entity
@Table(name="ADRESSES")
@NamedQuery(name = "Adresse.findAll", query = "SELECT adr FROM Adresse adr")

public class  Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String region;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String departement;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String commune;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String ville;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String localite;


    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "adresse", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "adresse", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.ALL},orphanRemoval = true)
    @Column(nullable = true)
    @JsonIgnore
    private List<EntrepriseClient> adrEntreprise;


    public Adresse() {
    }

    public Adresse(String region, String departement, String commune, String ville, String localite) {
        this.region = region;
        this.departement = departement;
        this.commune = commune;
        this.ville = ville;
        this.localite = localite;
    }

}
