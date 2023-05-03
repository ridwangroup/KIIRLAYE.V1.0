package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.Service_ipm_impl.CrudImpl;
import sn.ridwan.ipm.model.Agent;
import java.sql.SQLException;
import java.util.List;


@Path("/users/agents")
@RequestScoped
public class AgentController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
        List agentsList = cp.getAll("Agent.findAll");
        if(agentsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
        }
        // return Response.status(Response.Status.OK).entity("The operation of displaying all members was successful").build();
        return Response.ok(agentsList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        Object result = cp.getById(id);
        if(result.equals(null)) {
            // type(MediaType.APPLICATION_JSON_TYPE)
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the member with this id does not exist ").build();
        }
        //return Response.status(Response.Status.OK).entity("status : 200\nmsg : The display operation of the member with this id does not exist").build();
        return Response.ok(result).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Agent ag){
        Object result = cp.create(ag);
        //System.out.println("Object result : "+result);
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void update(@PathParam("id") Long id, Agent ag) {
        ag.setId(id);
        em.merge(ag);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Agent ag = em.find(Agent.class, id);
        em.remove(ag);
        return  Response.ok(ag).build();
    }

/*    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id,Agent ag) {
        Object result= cp.update(id,ag);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object remove(@PathParam("id") Long id){
        Agent ag = (Agent) cp.delete(id);
        return Response.ok(ag).build();
    }*/




   /* @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAgent(Agent user) {
        em.persist(user);
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
    }*/

}
