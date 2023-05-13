package sn.ridwan.ipm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.model.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "userIdd", target = "userIdd")
    @Mapping(source = "tel", target = "tel")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "roles", target = "roles")
    @Mapping(source = "image", target = "image")
    UserDto userToDTO(User user);
 }
