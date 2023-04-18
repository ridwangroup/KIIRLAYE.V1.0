package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sn.ridwan.ipm.exception.AgentException;
import sn.ridwan.ipm.model.Agent;

import java.util.List;

@ApplicationScoped
@Path("agents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgentController {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Agent> getUsers(){
        try {
            TypedQuery<Agent> query = em.createQuery("SELECT ag FROM Agent ag",Agent.class);
            return query.getResultList();
        } catch (AgentException e){
            System.out.println(e);
            return (List<Agent>) e;
        }
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Agent getUserById(@PathParam("id") Long id){
        return em.find(Agent.class,id);
    }

}
