package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Log
@Path("/users/admin")
@RequestScoped
public class AgentController {

    String msg ="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
    @Path("/agents")
   // @Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        Query namedQuery = em.createNamedQuery("Agent.findAll");
        namedQuery.getResultList();
        List userList = namedQuery.getResultList();
        if(userList.equals(null)) {
            msg="The display operation of the all members does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(userList).build();
    }

    @GET
    @Path("/agents/actif")
    // @Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllActif(){
        Query namedQuery = em.createNamedQuery("AgentActif.findAll");
        namedQuery.getResultList();
        List userList = namedQuery.getResultList();
        if(userList.equals(null)) {
            msg="The display operation of the all actif members does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(userList).build();
    }

    @GET
    @Path("/agents/inactif")
    // @Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllInActif(){
        Query namedQuery = em.createNamedQuery("AgentInActif.findAll");
        namedQuery.getResultList();
        List userList = namedQuery.getResultList();
        if(userList.equals(null)) {
            msg="The display operation of the all inactif members does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(userList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/agents/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        Object ag = em.find(Agent.class,id);
        if(ag==null) {
             msg = "The display operation of the member with this id does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(ag).build();
    }

    @POST
    @Secured
    @Log
    @Path("/agent/{agent_id}/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response add(@PathParam("agent_id") Long agent_id,Agent ag){
        ag.setCreateBy(agent_id);
        ag.setUpdateBy(agent_id);
        em.persist(ag);
        if(ag.equals(null)) {
            msg= "The operation to create a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create a Agent was successfully completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
    //@Secured
    @Log
    @Path("/agent/{id}/admin/{agent_id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id,@PathParam("agent_id") Long agent_id, Agent ag) {
        ag.setUpdateBy(agent_id);
        ag.setUpdatedAt(new Date());
        ag.setId(id);
        em.merge(ag);
        if(ag.equals(null)) {
            msg= "The operation to update a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update a Agent was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("/agent/{id}/admin/{agent_id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id,@PathParam("agent_id") Long agent_id)throws SQLException {
        Agent ag = em.find(Agent.class, id);
        ag.setUpdateBy(agent_id);
        ag.setUpdatedAt(new Date());
        ag.setEtat(false);
        em.merge(ag);
        if(ag.equals(null)) {
            msg= "The operation to delete a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg= "The operation to delete a Agent was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

}
