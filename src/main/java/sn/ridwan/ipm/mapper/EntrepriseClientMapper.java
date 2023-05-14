package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import sn.ridwan.ipm.dto.EntrepriseClientDto;
import sn.ridwan.ipm.model.EntrepriseClient;

@Local
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface EntrepriseClientMapper {
    EntrepriseClient toEntity(EntrepriseClientDto entrepriseClientDto);

    EntrepriseClientDto toDto(EntrepriseClient entrepriseClient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EntrepriseClient partialUpdate(EntrepriseClientDto entrepriseClientDto, @MappingTarget EntrepriseClient entrepriseClient);
}