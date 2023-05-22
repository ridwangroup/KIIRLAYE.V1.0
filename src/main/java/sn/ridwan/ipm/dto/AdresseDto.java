package sn.ridwan.ipm.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import sn.ridwan.ipm.model.EntrepriseClient;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.Adresse} entity
 */
@Data
public class AdresseDto implements Serializable {
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String region;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String departement;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String commune;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String ville;
    @NotEmpty(message = "Ce champ est obligatoire")
    private final String localite;
    private final List<EntrepriseClient> adrEntreprise;

    public AdresseDto(String region, String departement, String commune, String ville, String localite, List<EntrepriseClient> adrEntreprise) {
        this.region = region;
        this.departement = departement;
        this.commune = commune;
        this.ville = ville;
        this.localite = localite;
        this.adrEntreprise = adrEntreprise;
    }

    public String getRegion() {
        return region;
    }

    public String getDepartement() {
        return departement;
    }

    public String getCommune() {
        return commune;
    }

    public String getVille() {
        return ville;
    }

    public String getLocalite() {
        return localite;
    }

    public List<EntrepriseClient> getAdrEntreprise() {
        return adrEntreprise;
    }
}