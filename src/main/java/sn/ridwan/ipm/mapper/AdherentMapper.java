package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import sn.ridwan.ipm.dto.AdherentDto;
import sn.ridwan.ipm.model.Adherent;
@Local
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AdherentMapper {
    Adherent toEntity(AdherentDto adherentDto);

    AdherentDto toDto(Adherent adherent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adherent partialUpdate(AdherentDto adherentDto, @MappingTarget Adherent adherent);
}