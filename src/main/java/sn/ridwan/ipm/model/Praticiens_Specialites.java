package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQuery(name = "Praticiens_Specialites.findAll", query = "SELECT ps FROM Praticiens_Specialites ps WHERE ps.etatPS=true")
public class Praticiens_Specialites implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean etatPS=true;
    @OneToMany(mappedBy = "ps", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Responsable> responsableList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="specialite_id",referencedColumnName = "id",nullable = true,insertable=false, updatable=false)
    private Specialite specialite;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="praticien_id",referencedColumnName = "id",nullable = true,insertable=false, updatable=false)
    private Praticien praticien;


    public Praticiens_Specialites(boolean etatPS, List<Responsable> responsableList, Specialite specialite, Praticien praticien) {
        this.etatPS = etatPS;
        this.responsableList = responsableList;
        this.specialite = specialite;
        this.praticien = praticien;
    }
}
