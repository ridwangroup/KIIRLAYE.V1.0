package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="AGENTS")
@NamedQuery(name = "Agent.findAll", query = "SELECT ag FROM Agent ag")
public class Agent extends User{
    @Column
    private String adresse;
    @CreationTimestamp
    @Column
    private Date dateNaiss;
    @Column
    private String lieuNaiss;
    @Column
    private String conventionCollective;
    @Column
    //fonction
    private String poste;
    @Column
    //Superieur
    private String hierarchie;

    @OneToMany(mappedBy = "createBy", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<EntrepriseClient> adrEntreprise;

    @OneToMany(mappedBy = "createBy", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<StructureSanitaire> structureSanitaireList;

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Adherent> adherent;

    @OneToMany(mappedBy = "createBy", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Offre> offres;


    public Agent(String adresse, Date dateNaiss, String lieuNaiss, String conventionCollective, String poste, String hierarchie) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
    }

    public Agent(String nom, String prenom, String genre, String userIdd, String tel,String email,ArrayList<Role> roles, String image, String adresse, Date dateNaiss, String lieuNaiss, String conventionCollective, String poste, String hierarchie) {
        super(nom, prenom, genre, userIdd, tel,email, roles, image);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
    }
    public Agent(Long id) {
        super(id);
    }
}
