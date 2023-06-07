package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.EntrepriseClientDto;
import sn.ridwan.ipm.mapper.EntrepriseClientMapper;
import sn.ridwan.ipm.model.EntrepriseClient;

//@ApplicationScoped
public class DefaultEntrepriseClientMapper{

    /*public EntrepriseClient toEntity(EntrepriseClientDto entrepriseClientDto) {
        return null;
    }


    public EntrepriseClientDto toDto(EntrepriseClient entrepriseClient) {
        EntrepriseClientDto ecDto ;

        ecDto = new EntrepriseClientDto(
                entrepriseClient.getNomEntreprise(),
                entrepriseClient.getNinea(),
                entrepriseClient.getNumRegCommerce(),
                entrepriseClient.getNumeroTelephone(),
                entrepriseClient.getEmailEntreprise(),
                entrepriseClient.getLogo(),
                entrepriseClient.getCreatedAt(),
                entrepriseClient.getUpdatedAt(),
                entrepriseClient.getAdresse(),
                entrepriseClient.getAgent(),
                entrepriseClient.getAdherent());

        return ecDto;
    }


    public EntrepriseClient partialUpdate(EntrepriseClientDto entrepriseClientDto, EntrepriseClient entrepriseClient) {
        return null;
    }*/
}
