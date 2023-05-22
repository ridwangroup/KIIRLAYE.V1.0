package sn.ridwan.ipm.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Adresse;
import sn.ridwan.ipm.model.Agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.EntrepriseClient} entity
 */
@Data
public class EntrepriseClientDto implements Serializable {
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String nomEntreprise;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String ninea;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String numRegCommerce;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String numeroTelephone;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String emailEntreprise;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String logo;
    private final Date createdAt;
    private final Date updatedAt;
    private final Adresse adresse;
    private final Agent agent;
    private final List<Adherent> adherent;

    public EntrepriseClientDto(String nomEntreprise, String ninea, String numRegCommerce, String numeroTelephone, String emailEntreprise, String logo, Date createdAt, Date updatedAt, Adresse adresse, Agent agent, List<Adherent> adherent) {
        this.nomEntreprise = nomEntreprise;
        this.ninea = ninea;
        this.numRegCommerce = numRegCommerce;
        this.numeroTelephone = numeroTelephone;
        this.emailEntreprise = emailEntreprise;
        this.logo = logo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.adresse = adresse;
        this.agent = agent;
        this.adherent = adherent;
    }


    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public String getNinea() {
        return ninea;
    }

    public String getNumRegCommerce() {
        return numRegCommerce;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public String getLogo() {
        return logo;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Agent getAgent() {
        return agent;
    }

    public List<Adherent> getAdherent() {
        return adherent;
    }
}