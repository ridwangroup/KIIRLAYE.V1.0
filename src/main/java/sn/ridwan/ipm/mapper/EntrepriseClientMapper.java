package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import sn.ridwan.ipm.dto.EntrepriseClientDto;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.model.EntrepriseClient;
import sn.ridwan.ipm.model.User;

//@Local
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
//@Mapper
public interface EntrepriseClientMapper {
   /* EntrepriseClient toEntity(EntrepriseClientDto entrepriseClientDto);

    EntrepriseClientDto toDto(EntrepriseClient entrepriseClient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EntrepriseClient partialUpdate(EntrepriseClientDto entrepriseClientDto, @MappingTarget EntrepriseClient entrepriseClient);*/

  /*  EntrepriseClientMapper INSTANCE = Mappers.getMapper(EntrepriseClientMapper.class);
    @Mapping(source = "nomEntreprise", target = "nomEntreprise")
    @Mapping(source = "emailEntreprise", target = "emailEntreprise")
    @BeanMapping(ignoreByDefault = true)
    EntrepriseClientDto toDto(EntrepriseClient entrepriseClient);*/

}