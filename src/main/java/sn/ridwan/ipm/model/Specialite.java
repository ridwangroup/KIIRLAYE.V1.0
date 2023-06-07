package sn.ridwan.ipm.model;

import jakarta.persistence.*;


@Entity
@Table(name = "SPECIALITES")
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nomSpecialite;
    @Column
    private boolean etatSpecialite;

    public Specialite() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public boolean isEtatSpecialite() {
        return etatSpecialite;
    }

    public void setEtatSpecialite(boolean etatSpecialite) {
        this.etatSpecialite = etatSpecialite;
    }
}
