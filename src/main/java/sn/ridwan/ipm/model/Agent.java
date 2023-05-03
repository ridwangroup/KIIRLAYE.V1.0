package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor()
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
    @Column(name = "matricule", unique=true)
    private String matricule;
    @Column
    private String conventionCollective;
    @Column
    private String poste;
    @Column
    private String hierarchie;


    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<EntrepriseClient> adrEntreprise;

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Adherent> adherent;


    public Agent(String nom, String prenom, String genre, String email, String numTelephone, String userIdd, String role, String adresse, String lieuNaiss, String matricule, String conventionCollective, String poste, String hierarchie) {
        super(nom, prenom, genre, email, numTelephone, userIdd, role);
        this.adresse = adresse;
        this.lieuNaiss = lieuNaiss;
        this.matricule = matricule;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
    }

    public Agent(String adresse, String lieuNaiss, String matricule, String conventionCollective, String poste, String hierarchie) {
        this.adresse = adresse;
        this.lieuNaiss = lieuNaiss;
        this.matricule = matricule;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
    }

    public Agent(Long id) {
        super(id);
    }


}
