package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import sn.ridwan.ipm.dto.AgentDto;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.User;

import java.util.List;

//@Local
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "nom", target = "nomDto")
    @Mapping(source = "prenom", target = "prenomDto")
    @Mapping(source = "email", target = "emailDto")
    //List<AgentDto> toAgentDTOs(List<Agent> agents)
    @BeanMapping(ignoreByDefault = true)
    UserDto toDto(User user);
}