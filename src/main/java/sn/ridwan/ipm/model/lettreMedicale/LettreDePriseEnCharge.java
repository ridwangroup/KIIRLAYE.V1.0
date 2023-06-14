package sn.ridwan.ipm.model.lettreMedicale;

import jakarta.persistence.*;
import sn.ridwan.ipm.model.Adherent;

@Entity
@Table(name = "LPC")
public class LettreDePriseEnCharge extends LetterDePriseEnChargeMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Adherent adherent;

    public LettreDePriseEnCharge() {
    }

    public LettreDePriseEnCharge(Adherent adherent) {
        this.adherent = adherent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
}
