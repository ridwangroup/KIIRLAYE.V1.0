package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AdherentDto;
import sn.ridwan.ipm.mapper.AdherentMapper;
import sn.ridwan.ipm.model.Adherent;

@ApplicationScoped
public class DefaultAdherentMapper implements AdherentMapper {

    @Override
    public Adherent toEntity(AdherentDto adherentDto) {
        return null;
    }

    @Override
    public AdherentDto toDto(Adherent adherent) {
        return null;
    }

    @Override
    public Adherent partialUpdate(AdherentDto adherentDto, Adherent adherent) {
        return null;
    }
}
