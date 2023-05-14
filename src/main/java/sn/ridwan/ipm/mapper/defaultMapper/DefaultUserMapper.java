package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.mapper.UserMapper;
import sn.ridwan.ipm.model.User;
@ApplicationScoped
public class DefaultUserMapper implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto;
        userDto = new UserDto(
                user.getNom(),
                user.getPrenom(),
                user.getGenre(),
                user.getUserIdd(),
                user.getTel(),
                user.getEmail(),
                user.getRoles(),
                user.getImage(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
        return userDto;
    }

    @Override
    public User partialUpdate(UserDto userDto, User user) {
        return null;
    }
}
