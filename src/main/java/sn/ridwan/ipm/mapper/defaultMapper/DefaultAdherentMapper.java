package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AdherentDto;
import sn.ridwan.ipm.mapper.AdherentMapper;
import sn.ridwan.ipm.model.Adherent;

//@ApplicationScoped
public class DefaultAdherentMapper {


   /* public Adherent toEntity(AdherentDto adherentDto) {
        Adherent adherent = new Adherent();
        adherent.setNom(adherentDto.getNom());
        adherent.setPrenom(adherentDto.getPrenom());
        adherent.setGenre(adherentDto.getGenre());
        adherent.setUserIdd(adherentDto.getUserIdd());
        adherent.setTel(adherentDto.getTel());
        adherent.setEmail(adherentDto.getEmail());
        adherent.setRoles(adherentDto.getRoles());
        adherent.setImage(adherentDto.getImage());
        return adherent;
    }


    public AdherentDto toDto(Adherent adherent) {
        AdherentDto adherentDto ;
        adherentDto = new AdherentDto(
                adherent.getNom(),
                adherent.getPrenom(),
                adherent.getGenre(),
                adherent.getUserIdd(),
                adherent.getTel(),
                adherent.getEmail(),
                adherent.getRoles(),
                adherent.getImage(),
                adherent.getAdresse(),
                adherent.getDateNaiss(),
                adherent.getLieuNaiss());
                //adherent.getAgent(),
                //adherent.getEntrepriseClients());
        return adherentDto;



    }


    public Adherent partialUpdate(AdherentDto adherentDto, Adherent adherent) {
        return null;
    }*/
}
