package sn.ridwan.ipm.mapper.defaultMapper;


import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AdresseDto;
import sn.ridwan.ipm.mapper.AdresseMapper;
import sn.ridwan.ipm.model.Adresse;

//@ApplicationScoped
public class DefaultAdresseMapper {

    //@Override
   /* public Adresse toEntity(AdresseDto adresseDto) {
        return null;
    }

   // @Override
    public AdresseDto toDto(Adresse adresse) {
        AdresseDto adresseDto;
        adresseDto = new AdresseDto(
                adresse.getRegion(),
                adresse.getDepartement(),
                adresse.getCommune(),
                adresse.getVille(),
                adresse.getLocalite(),
                adresse.getAdrEntreprise()
        );
        return adresseDto;
    }

    //@Override
    public Adresse partialUpdate(AdresseDto adresseDto, Adresse adresse) {
        return null;
    }*/
}
