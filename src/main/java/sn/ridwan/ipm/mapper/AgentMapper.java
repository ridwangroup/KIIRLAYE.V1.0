package sn.ridwan.ipm.mapper;

import jakarta.ejb.Local;
import org.mapstruct.*;
import sn.ridwan.ipm.dto.AgentDto;
import sn.ridwan.ipm.model.Agent;
@Local
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {EntrepriseClientMapper.class, AdherentMapper.class})
public interface AgentMapper {
    Agent toEntity(AgentDto agentDto);

    AgentDto toDto(Agent agent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Agent partialUpdate(AgentDto agentDto, @MappingTarget Agent agent);

    @AfterMapping
    default void linkAdrEntreprise(@MappingTarget Agent agent) {
        agent.getAdrEntreprise().forEach(adrEntreprise -> adrEntreprise.setAgent(agent));
    }

    @AfterMapping
    default void linkAdherent(@MappingTarget Agent agent) {
        agent.getAdherent().forEach(adherent -> adherent.setAgent(agent));
    }
}