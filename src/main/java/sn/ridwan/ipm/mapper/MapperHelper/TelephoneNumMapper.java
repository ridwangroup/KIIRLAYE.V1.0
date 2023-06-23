package sn.ridwan.ipm.mapper.MapperHelper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.ridwan.ipm.dto.helperdto.NumeroTelephoneDto;
import sn.ridwan.ipm.model.helper.NumeroTelephone;

@Mapper
public interface NumeroTelephoneMapper {
    @Mapping(source = "idNumtele",target = "iddto")
    @Mapping(source = "numeroPrincipale",target = "numeroPrincipaldto")
    @Mapping(source = "numeroSeconsairedto",target = "numeroSeconsairedto")
    @Mapping(source = "numeroFacultative", target = "numeroFacultativedto")
    NumeroTelephoneDto numeroTelephonetoDto(NumeroTelephone numeroTelephone);

    @Mapping(source = "iddto", target = "idNumtele")
    @Mapping(source = "numeroPrincipaldto", target = "numeroPrincipale")
    @Mapping(source = "numeroSeconsairedto", target = "numeroSeconsairedto")
    @Mapping(source = "numeroFacultativedto", target = "numeroFacultative")
    NumeroTelephone numeroTelephoentoEntity(NumeroTelephoneDto numeroTelephoneDto);
}
