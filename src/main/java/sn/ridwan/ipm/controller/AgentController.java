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
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.List;

@Log
@Path("/users/agents")
@RequestScoped
public class AgentController {

    String msg ="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
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
    //@Secured
    @Log
    @Path("/{id}")
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
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response add(Agent ag){
        //Object result = cp.create(ag);
        em.persist(ag);
        if(ag.equals(null)) {
            msg= "The operation to create a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        User user = new User();
        user.setEmail(ag.getAg_email());
        user.setTel(ag.getAg_tel());
        user.setUserIdd(ag.getMatricule());
        em.merge(user);
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
            msg= "The operation to update a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a Agent was successful completed ").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Agent ag = em.find(Agent.class, id);
        ag.setIsEtat(false);
        em.merge(ag);
        if(ag.equals(null)) {
            msg= "The operation to delete a Agent was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to delete a Agent was successful completed ").build();
    }

}
