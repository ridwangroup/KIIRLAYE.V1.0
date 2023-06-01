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
    private String pays;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String region;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String ville;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String departement;

    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String rue_entrprise;


    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "adresse", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "adresse", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.ALL},orphanRemoval = true)
    @Column(nullable = true)
    @JsonIgnore
    private List<EntrepriseClient> adrEntreprise;


    public Adresse() {
    }

    public Adresse(String pays,String region, String ville,String departement, String rue_entrprise) {
        this.pays = pays;
        this.region = region;
        this.ville = ville;
        this.departement = departement;
        this.rue_entrprise = rue_entrprise;
    }

}
