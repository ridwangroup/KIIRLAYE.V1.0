package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "RESPONSABLES")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean etatResponsable;
    @Enumerated(EnumType.STRING)
    @Column
    @ElementCollection
    private ArrayList<Fonction> fonctions;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="ps_id",referencedColumnName = "id",updatable=false,nullable = false)
    private Praticiens_Specialites ps;

    public Responsable() {
    }

    public long getId() {
        return id;
    }

    public boolean isEtatResponsable() {
        return etatResponsable;
    }

    public void setEtatResponsable(boolean etatResponsable) {
        this.etatResponsable = etatResponsable;
    }

    public ArrayList<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(ArrayList<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
}
