package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Praticiens_Specialites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long praticien_id;
    @Column
    private long specialite_id;
    @Column
    private boolean etatPS;
    @OneToMany(mappedBy = "ps", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Responsable> responsableList;

    public long getId() {
        return id;
    }

    public long getPraticien_id() {
        return praticien_id;
    }

    public void setPraticien_id(long praticien_id) {
        this.praticien_id = praticien_id;
    }

    public long getSpecialite_id() {
        return specialite_id;
    }

    public void setSpecialite_id(long specialite_id) {
        this.specialite_id = specialite_id;
    }

    public boolean isEtatPS() {
        return etatPS;
    }

    public void setEtatPS(boolean etatPS) {
        this.etatPS = etatPS;
    }
}
