package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import sn.ridwan.ipm.dto.AdresseDto;
import sn.ridwan.ipm.model.Adresse;
@Local
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AdresseMapper {
    Adresse toEntity(AdresseDto adresseDto);

    AdresseDto toDto(Adresse adresse);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adresse partialUpdate(AdresseDto adresseDto, @MappingTarget Adresse adresse);
}