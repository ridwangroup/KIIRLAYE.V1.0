package sn.ridwan.ipm.dto;

import lombok.Data;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.EntrepriseClient;
import sn.ridwan.ipm.model.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.Agent} entity
 */
@Data
public class AgentDto implements Serializable {
    private final String nom;
    private final String prenom;
    private final String genre;
    private final String userIdd;
    private final String tel;
    private final String email;
    private final ArrayList<Role> roles;
    private final String image;
    private final String adresse;
    private final Date dateNaiss;
    private final String lieuNaiss;
    private final String conventionCollective;
    private final String poste;
    private final String hierarchie;
    private final List<EntrepriseClient> adrEntreprise;
    private final List<Adherent> adherent;

    public AgentDto(String nom, String prenom, String genre, String userIdd, String tel, String email, ArrayList<Role> roles, String image, String adresse, Date dateNaiss, String lieuNaiss, String conventionCollective, String poste, String hierarchie, List<EntrepriseClient> adrEntreprise, List<Adherent> adherent) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.tel = tel;
        this.email = email;
        this.roles = roles;
        this.image = image;
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.conventionCollective = conventionCollective;
        this.poste = poste;
        this.hierarchie = hierarchie;
        this.adrEntreprise = adrEntreprise;
        this.adherent = adherent;
    }

}