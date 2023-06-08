package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRATICIENS")
@NamedQuery(name = "Praticien.findAll", query = "SELECT praticien FROM Praticien praticien WHERE praticien.etatPraticien=true")
public class Praticien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String matricule;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private boolean etatPraticien=true;

    @OneToMany(mappedBy = "praticien", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Praticiens_Specialites> praticiensSpecialitesList;

    public Praticien(String matricule, String nom, String prenom, String telephone, String email, boolean etatPraticien, List<Praticiens_Specialites> praticiensSpecialitesList) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.etatPraticien = etatPraticien;
        this.praticiensSpecialitesList = praticiensSpecialitesList;
    }
}