package sn.ridwan.ipm.model.lettreMedicale;

import jakarta.persistence.*;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.StructureSanitaire;

import java.time.LocalDate;

@Entity
@Table(name = "DEVIS")
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
    private LocalDate dateEmission;
    @Column
    private String designation;
    @Column
    private double montant;
    @Column
    private String dureeDeValidite;
    @Column
    @ManyToOne
    private Adherent adherents;
    @Column
    @ManyToOne
    private StructureSanitaire structureSanitaire;
    @Enumerated
    private Validation status;

    public Devis() {
    }

    public Devis(String nom, LocalDate dateEmission, String designation, Double montant, String dureeDeValidite, Validation status) {
        this.nom = nom;
        this.dateEmission = dateEmission;
        this.designation = designation;
        this.montant = montant;
        this.dureeDeValidite = dureeDeValidite;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDureeDeValidite() {
        return dureeDeValidite;
    }

    public void setDureeDeValidite(String dureeDeValidite) {
        this.dureeDeValidite = dureeDeValidite;
    }

    public Validation getStatus() {
        return status;
    }

    public void setStatus(Validation status) {
        this.status = status;
    }
}
