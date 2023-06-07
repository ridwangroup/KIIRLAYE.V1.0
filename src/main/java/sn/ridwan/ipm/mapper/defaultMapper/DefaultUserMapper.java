package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.mapper.UserMapper;
import sn.ridwan.ipm.model.User;
//@ApplicationScoped
public class DefaultUserMapper {


 /*   public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setGenre(userDto.getGenre());
        user.setUserIdd(userDto.getUserIdd());
        user.setTel(userDto.getTel());
        user.setEmail(userDto.getEmail());
        user.setRoles(userDto.getRoles());
        user.setImage(userDto.getImage());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());
        return user;

    }*/


  /*  public UserDto toDto(User user) {
        UserDto userDto = new UserDto(
        user.getId(),
        user.getNom(),
        user.getPrenom(),
        user.getGenre(),
        user.getUserIdd(),
        user.getTel(),
        user.getEmail(),
        user.getRoles(),
        user.getImage(),
        user.getCreatedAt(),
        user.getUpdatedAt());
        return userDto;
    }*/


    /*public User partialUpdate(UserDto userDto, User user) {
        return null;
    }*/
}
