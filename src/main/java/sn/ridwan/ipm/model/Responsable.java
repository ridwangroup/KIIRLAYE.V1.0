package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RESPONSABLES")
@NamedQuery(name = "Responsable.findAll", query = "SELECT responsable FROM Responsable responsable WHERE responsable.etatResponsable=true")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean etatResponsable=true;
    @Enumerated(EnumType.STRING)
    @Column
    private ArrayList<Fonction> fonctions;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="ps_id",referencedColumnName = "id",updatable=false,nullable = false)
    private Praticiens_Specialites ps;

    public Responsable(boolean etatResponsable, ArrayList<Fonction> fonctions, Praticiens_Specialites ps) {
        this.etatResponsable = etatResponsable;
        this.fonctions = fonctions;
        this.ps = ps;
    }
}