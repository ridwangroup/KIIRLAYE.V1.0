package sn.ridwan.ipm.mapper.defaultMapper;

import jakarta.enterprise.context.ApplicationScoped;
import sn.ridwan.ipm.dto.AdherentDto;
import sn.ridwan.ipm.dto.AgentDto;
import sn.ridwan.ipm.mapper.AgentMapper;
import sn.ridwan.ipm.model.Agent;
//@ApplicationScoped
public class DefaultAgentMapper {
   // @Override
   /* public Agent toEntity(AgentDto agentDto) {
        return null;
    }

    //@Override
    public AgentDto toDto(Agent agent) {

        AgentDto agentDto ;
        agentDto = new AgentDto(
                agent.getNom(),
                agent.getPrenom(),
                agent.getGenre(),
                agent.getUserIdd(),
                agent.getTel(),
                agent.getEmail(),
                agent.getRoles(),
                agent.getImage(),
                agent.getAdresse(),
                agent.getDateNaiss(),
                agent.getLieuNaiss(),
                agent.getConventionCollective(),
                agent.getPoste(),
                agent.getHierarchie(),
                agent.getAdrEntreprise(),
                agent.getAdherent()
        );
        return agentDto;
    }

    //@Override
    public Agent partialUpdate(AgentDto agentDto, Agent agent) {
        return null;
    }*/

    //@Override
/*    public void linkAdrEntreprise(Agent agent) {
        AgentMapper.super.linkAdrEntreprise(agent);
    }

    //@Override
    public void linkAdherent(Agent agent) {
        AgentMapper.super.linkAdherent(agent);
    }*/
}
