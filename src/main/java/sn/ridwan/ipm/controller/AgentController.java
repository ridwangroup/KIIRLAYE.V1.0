package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.ipm.model.Agent;
import java.sql.SQLException;
import java.util.List;

@Log
@Path("/users/agents")
@RequestScoped
public class AgentController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;
    @GET
   // @Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
        List agentsList = cp.getAll("Agent.findAll");
        if(agentsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
        }
        return Response.ok(agentsList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        Object result = cp.getById(id);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the member with this id does not exist ").build();
        }
        return Response.ok(result).build();
    }

    @POST
    @Secured
    @Log
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Agent ag){
        Object result = cp.create(ag);
        if(result.equals(null)) {
            return  Response.status(Response.Status.NOT_FOUND).entity("The operation to create a Agent was not successful ").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to create a Agent was successfully completed ").build();
    }

    @PUT
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Agent ag) {
        ag.setId(id);
        em.merge(ag);
        if(ag.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a Agent was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a Agent was successful completed ").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Agent ag = em.find(Agent.class, id);
        em.remove(ag);
        if(ag.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a Agent was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to delete a Agent was successful completed ").build();
    }

}
