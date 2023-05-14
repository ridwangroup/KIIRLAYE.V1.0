package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.EntrepriseClientDto;
import sn.ridwan.ipm.mapper.EntrepriseClientMapper;
import sn.ridwan.ipm.model.EntrepriseClient;

@ApplicationScoped
public class DefaultEntrepriseClientMapper implements EntrepriseClientMapper {
    @Override
    public EntrepriseClient toEntity(EntrepriseClientDto entrepriseClientDto) {
        return null;
    }

    @Override
    public EntrepriseClientDto toDto(EntrepriseClient entrepriseClient) {
        return null;
    }

    @Override
    public EntrepriseClient partialUpdate(EntrepriseClientDto entrepriseClientDto, EntrepriseClient entrepriseClient) {
        return null;
    }
}
