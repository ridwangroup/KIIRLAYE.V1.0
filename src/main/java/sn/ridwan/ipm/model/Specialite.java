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
@Table(name = "SPECIALITES")
@NamedQuery(name = "Specialite.findAll", query = "SELECT specialite FROM Specialite specialite WHERE specialite.etatSpecialite=true")
public class Specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nomSpecialite;
    @Column
    private boolean etatSpecialite=true;

    @OneToMany(mappedBy = "specialite", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Praticiens_Specialites> praticiensSpecialitesList;

    public Specialite(String nomSpecialite, boolean etatSpecialite, List<Praticiens_Specialites> praticiensSpecialitesList) {
        this.nomSpecialite = nomSpecialite;
        this.etatSpecialite = etatSpecialite;
        this.praticiensSpecialitesList = praticiensSpecialitesList;
    }
}