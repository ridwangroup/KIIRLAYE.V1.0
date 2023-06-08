package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@Table(name = "ENTREPRISE")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String nomEntreprise;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String ninea;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String numRegCommerce;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String numeroTelephone;
    @NotEmpty(message = "Ce champ est obligatoire")
    @Column
    private String emailEntreprise;
    @Column
    //private byte[] logo;
    private String logo = "https://www.w3schools.com/howto/img_avatar.png";
    @Column
    private String fax;
    @Column
    private boolean etatEntreprise = false;
    public boolean isEtatEntreprise() {
        return etatEntreprise;
    }
    public void setEtatEntreprise(boolean etatEntreprise) {
        this.etatEntreprise = etatEntreprise;
    }
    public Entreprise() {
    }
    public Entreprise(String nomEntreprise, String ninea, String numRegCommerce, String numeroTelephone, String emailEntreprise, String logo, String fax, boolean etatEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.ninea = ninea;
        this.numRegCommerce = numRegCommerce;
        this.numeroTelephone = numeroTelephone;
        this.emailEntreprise = emailEntreprise;
        this.logo = logo;
        this.fax = fax;
        this.etatEntreprise = etatEntreprise;
    }

    public Entreprise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getNumRegCommerce() {
        return numRegCommerce;
    }

    public void setNumRegCommerce(String numRegCommerce) {
        this.numRegCommerce = numRegCommerce;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public void setEmailEntreprise(String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}