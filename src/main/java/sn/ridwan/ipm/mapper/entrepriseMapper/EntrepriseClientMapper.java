package sn.ridwan.ipm.mapper.entrepriseMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.ridwan.ipm.dto.entreprisedto.EntrepriseDto;
import sn.ridwan.ipm.model.EntrepriseClient;

/*le Mapping se fait de facon unidirectionnelle du domain au Dto*/
@Mapper
public interface ClientEnterpriseBaseInfoMapper {
    @Mapping(source = "nomEntreprise", target = "nomEntrdto")
    @Mapping(source = "ninea", target = "nineaEntrdto")
    @Mapping(source = "numRegCommerce", target = "numRCEntrdto")
    @Mapping(source = "adresse", target = "adresseEntrdto")
    @Mapping(source = "numeroTelephone", target = "numtelephoneEntrdto")
    @Mapping(source = "emailEntreprise", target = "emailEntrdto")
    @Mapping(source = "fax", target = "faxEntrdto")
    @Mapping(source = "logo", target = "logoEntrdto")
    public EntrepriseDto showClientEnterprisetoDto(EntrepriseClient entrepriseClient);


    @Mapping(source = "nomEntreprise", target = "nomEntreprise")
    @Mapping(source = "ninea", target = "ninea")
    @Mapping(source = "numRegCommerce", target = "numRC")
    @Mapping(source = "adresse", target = "adresse")
    @Mapping(source = "numeroTelephone", target = "numtelephone")
    @Mapping(source = "emailEntreprise", target = "email")
    @Mapping(source = "fax", target = "fax")
    @Mapping(source = "logo", target = "logo")
    public EntrepriseClient showClientEnterprisetoEntity(EntrepriseDto entrepriseClientDto);
}
