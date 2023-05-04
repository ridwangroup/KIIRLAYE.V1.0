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

    @Column(name = "ag_mail",unique = true)
    //@Pattern(regexp = "^(.+)@(.+)$")
    private String ag_email;
    @Column(name = "ag_tel", unique=true)
    // @Pattern(regexp = "^(221|00221|\\+221)?(77|78|75|70|76)[0-9]{7}$")
    private String ag_tel;


    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<EntrepriseClient> adrEntreprise;

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Adherent> adherent;


    public Agent(String adresse, Date dateNaiss, String lieuNaiss, String matricule, String conventionCollective, String poste, String hierarchie, String ag_email, String ag_tel) {
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.matricule = matricule;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
        this.ag_email = ag_email;
        this.ag_tel = ag_tel;
    }

    public Agent(String nom, String prenom, String genre, String userIdd, String role, String adresse, Date dateNaiss, String lieuNaiss, String matricule, String conventionCollective, String poste, String hierarchie, String ag_email, String ag_tel) {
        super(nom, prenom, genre, userIdd, role);
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.matricule = matricule;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
        this.ag_email = ag_email;
        this.ag_tel = ag_tel;
    }

    public Agent(Long id) {
        super(id);
    }


}
