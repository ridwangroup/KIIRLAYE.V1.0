package sn.ridwan.ipm.model.lettreMedicale;

import java.time.LocalDate;

public abstract class LetterDePriseEnChargeMedical {
    private String nomLettre;
    private LocalDate dateEmission;
    private String dureeDeValidite;
    private ServicesMedical servicesMedical;
    private String designation;

    public String getNomLettre() {
        return nomLettre;
    }

    public void setNomLettre(String nomLettre) {
        this.nomLettre = nomLettre;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getDureeDeValidite() {
        return dureeDeValidite;
    }

    public void setDureeDeValidite(String dureeDeValidite) {
        this.dureeDeValidite = dureeDeValidite;
    }

    public ServicesMedical getServicesMedical() {
        return servicesMedical;
    }

    public void setServicesMedical(ServicesMedical servicesMedical) {
        this.servicesMedical = servicesMedical;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
