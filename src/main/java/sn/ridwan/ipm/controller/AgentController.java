package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Agent;

import java.sql.SQLException;


@ApplicationScoped
@Path("/users/agents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AgentController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsers()throws SQLException {
        TypedQuery<Agent> query = em.createQuery("SELECT ag FROM Agent ag",Agent.class);
        return Response.ok(query.getResultList()).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Agent getUserById(@PathParam("id") Long id)throws SQLException{
        return em.find(Agent.class,id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("id") Long id, Agent ag) {
        ag.setId(id);
        em.merge(ag);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id)throws SQLException {
        Agent ag = em.find(Agent.class, id);
        em.remove(ag);
        return  Response.ok(ag).build();
    }

}
