package sn.ridwan.ipm.model.lettreMedicale;

import jakarta.persistence.ManyToOne;
import sn.ridwan.ipm.model.Adherent;


public class LettreDeGarentie extends LetterDePriseEnChargeMedical {
    @ManyToOne
    private Adherent adherent;
    private Devis devis;
}
