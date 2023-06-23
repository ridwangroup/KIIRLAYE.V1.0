package sn.ridwan.ipm.dto.entreprisedto;

import sn.ridwan.ipm.dto.helperdto.AdresseDto;

import java.io.Serializable;
import java.util.List;

/*
@Le Mapper communique avec le domain metier


    les information d'access a un agent en consultation (lecture seul)
    les agent qui ont un role agent peuvent y avoir acces
    Affiche les information basique d'une entreprise
* */
public class EntrepriseClientDto implements Serializable {
    private long id;
    private String nomEntrdto;
    private String nineaEntrdto;
    private String numRCEntrdto;
    private AdresseDto adresseEntrdto;
    private String numtelephoneEntrdto;
    private String emailEntrdto;
    private String faxEntrdto;
    private byte[] logoEntrdto;
    private List<AdherentDto> adherentDtoList;

    public EntrepriseClientDto() {
    }

    public EntrepriseClientDto(String nomEntrdto, String nineaEntrdto, String numRCEntrdto, AdresseDto adresseEntrdto,
                               String numtelephoneEntrdto, String emailEntrdto, String faxEntrdto, byte[] logoEntrdto, List<AdherentDto> adherentDtoList) {
        this.nomEntrdto = nomEntrdto;
        this.nineaEntrdto = nineaEntrdto;
        this.numRCEntrdto = numRCEntrdto;
        this.adresseEntrdto = adresseEntrdto;
        this.numtelephoneEntrdto = numtelephoneEntrdto;
        this.emailEntrdto = emailEntrdto;
        this.faxEntrdto = faxEntrdto;
        this.logoEntrdto = logoEntrdto;
        this.adherentDtoList = adherentDtoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomEntrdto() {
        return nomEntrdto;
    }

    public void setNomEntrdto(String nomEntrdto) {
        this.nomEntrdto = nomEntrdto;
    }

    public String getNineaEntrdto() {
        return nineaEntrdto;
    }

    public void setNineaEntrdto(String nineaEntrdto) {
        this.nineaEntrdto = nineaEntrdto;
    }

    public String getNumRCEntrdto() {
        return numRCEntrdto;
    }

    public void setNumRCEntrdto(String numRCEntrdto) {
        this.numRCEntrdto = numRCEntrdto;
    }

    public AdresseDto getAdresseEntrdto() {
        return adresseEntrdto;
    }

    public void setAdresseEntrdto(AdresseDto adresseEntrdto) {
        this.adresseEntrdto = adresseEntrdto;
    }

    public String getNumtelephoneEntrdto() {
        return numtelephoneEntrdto;
    }

    public void setNumtelephoneEntrdto(String numtelephoneEntrdto) {
        this.numtelephoneEntrdto = numtelephoneEntrdto;
    }

    public String getEmailEntrdto() {
        return emailEntrdto;
    }

    public void setEmailEntrdto(String emailEntrdto) {
        this.emailEntrdto = emailEntrdto;
    }

    public String getFaxEntrdto() {
        return faxEntrdto;
    }

    public void setFaxEntrdto(String faxEntrdto) {
        this.faxEntrdto = faxEntrdto;
    }

    public byte[] getLogoEntrdto() {
        return logoEntrdto;
    }

    public void setLogoEntrdto(byte[] logoEntrdto) {
        this.logoEntrdto = logoEntrdto;
    }

    public List<AdherentDto> getAdherentDtoList() {
        return adherentDtoList;
    }

    public void setAdherentDtoList(List<AdherentDto> adherentDtoList) {
        this.adherentDtoList = adherentDtoList;
    }
}