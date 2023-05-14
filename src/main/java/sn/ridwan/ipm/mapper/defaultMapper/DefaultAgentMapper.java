package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AgentDto;
import sn.ridwan.ipm.mapper.AgentMapper;
import sn.ridwan.ipm.model.Agent;
@ApplicationScoped
public class DefaultAgentMapper implements AgentMapper {
    @Override
    public Agent toEntity(AgentDto agentDto) {
        return null;
    }

    @Override
    public AgentDto toDto(Agent agent) {
        return null;
    }

    @Override
    public Agent partialUpdate(AgentDto agentDto, Agent agent) {
        return null;
    }

    @Override
    public void linkAdrEntreprise(Agent agent) {
        AgentMapper.super.linkAdrEntreprise(agent);
    }

    @Override
    public void linkAdherent(Agent agent) {
        AgentMapper.super.linkAdherent(agent);
    }
}
