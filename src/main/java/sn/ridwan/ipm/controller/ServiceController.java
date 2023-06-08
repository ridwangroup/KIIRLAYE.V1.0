package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.Service;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@Path("/services")
@Log
@RequestScoped
public class ServiceController {
    String msg ="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;


    @GET
    //@Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List adherentsList = cp.getAll("Service.findAll");
        if(adherentsList.equals(null)) {
            msg="The display operation of the all services does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(adherentsList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        msg="The display operation of the service with this id does not exist";
        Object result = em.find(Service.class,id);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(result).build();
    }

    @POST
    //@Secured
    @Log
    @Path("/agent/{agent_id}/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(@PathParam("agent_id") Long agent_id,Service service){
        service.setCreateBy(new Agent(agent_id));
       // service.getNomService().toUpperCase();
        service.setUpdateBy(agent_id);
        Object result = cp.create(service);
        if(result.equals(null)) {
            msg="The operation to create a service was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create a service was successfully completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
    @Log
    //@Secured
    @Path("/{id}/agent/{agent_id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("agent_id") Long agent_id,@PathParam("id") Long id, Service service) {
        service.setUpdateBy(agent_id);
        service.setUpdatedAt(new Date());
        service.setId(id);
        em.merge(service);
        if(service.equals(null)) {
            msg="The operation to update a service was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update a service was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @DELETE
    @Log
    //@Secured
    @Path("/{id}/agent/{agent_id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("agent_id") Long agent_id,@PathParam("id") Long id)throws SQLException {
        Service service = em.find(Service.class, id);
        service.setUpdateBy(agent_id);
        service.setUpdatedAt(new Date());
        service.setEtatService(false);
        em.merge(service);
        if(service.equals(null)) {
            msg="The operation to delete a service was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to delete a service was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }
}
