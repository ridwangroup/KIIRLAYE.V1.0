package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import sn.ridwan.ipm.dto.AdherentDto;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.User;

//@Local
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
//@Mapper
public interface AdherentMapper {
 /*   Adherent toEntity(AdherentDto adherentDto);

    AdherentDto toDto(Adherent adherent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adherent partialUpdate(AdherentDto adherentDto, @MappingTarget Adherent adherent);*/

   /* AdherentMapper INSTANCE = Mappers.getMapper(AdherentMapper.class);

    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "email", target = "email")
    @BeanMapping(ignoreByDefault = true)
    AdherentDto toDto(Adherent adherent);*/
}