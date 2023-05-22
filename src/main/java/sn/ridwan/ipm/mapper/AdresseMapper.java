package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import sn.ridwan.ipm.dto.AdresseDto;
import sn.ridwan.ipm.dto.EntrepriseClientDto;
import sn.ridwan.ipm.model.Adresse;
import sn.ridwan.ipm.model.EntrepriseClient;

//@Local
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
//@Mapper
public interface AdresseMapper {
   /* Adresse toEntity(AdresseDto adresseDto);

    AdresseDto toDto(Adresse adresse);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adresse partialUpdate(AdresseDto adresseDto, @MappingTarget Adresse adresse);*/

    AdresseMapper INSTANCE = Mappers.getMapper(AdresseMapper.class);
   /* @Mapping(source = "region", target = "region")
    @Mapping(source = "ville", target = "ville")
    @BeanMapping(ignoreByDefault = true)
    AdresseDto toDto(Adresse adresse);*/
}