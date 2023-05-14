package sn.ridwan.ipm.mapper.defaultMapper;


import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AdresseDto;
import sn.ridwan.ipm.mapper.AdresseMapper;
import sn.ridwan.ipm.model.Adresse;

@ApplicationScoped
public class DefaultAdresseMapper implements AdresseMapper {

    @Override
    public Adresse toEntity(AdresseDto adresseDto) {
        return null;
    }

    @Override
    public AdresseDto toDto(Adresse adresse) {
        return null;
    }

    @Override
    public Adresse partialUpdate(AdresseDto adresseDto, Adresse adresse) {
        return null;
    }
}
