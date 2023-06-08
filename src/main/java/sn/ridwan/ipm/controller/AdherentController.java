package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Log
@Path("/users/adherents")
@RequestScoped
public class AdherentController {
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
        List adherentsList = cp.getAll("Adherent.findAll");
        if(adherentsList.equals(null)) {
            msg="The display operation of the all members does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(adherentsList).build();
    }


    @GET
    //@Secured
    @Path("/actif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllActif(){
        List adherentsList = cp.getAll("AdherentActif.findAll");
        if(adherentsList.equals(null)) {
            msg="The display operation of the all actif members does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(adherentsList).build();
    }
    @GET
    //@Secured
    @Path("/inactif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllInActif(){
        List adherentsList = cp.getAll("AdherentInActif.findAll");
        if(adherentsList.equals(null)) {
            msg="The display operation of the all inActif members does not exist";
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
        msg="The display operation of the member with this id does not exist";
        Object result = em.find(Adherent.class,id);
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
    public Object add(@PathParam("agent_id") Long agent_id,Adherent ad){
        ad.setCreateBy(new Agent(agent_id));
        ad.setUpdateBy(agent_id);
        Object result = cp.create(ad);
        if(result.equals(null)) {
            msg="The operation to create a member was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create a member was successfully completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
    @Log
    //@Secured
    @Path("/{id}/agent/{agent_id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("agent_id") Long agent_id,@PathParam("id") Long id, Adherent ad) {
        ad.setUpdateBy(agent_id);
        ad.setUpdatedAt(new Date());
        ad.setId(id);
        em.merge(ad);
        if(ad.equals(null)) {
            msg="The operation to update a member was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update a member was successful completed ";
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
        Adherent ad = em.find(Adherent.class, id);
        ad.setUpdateBy(agent_id);
        ad.setUpdatedAt(new Date());
        ad.setEtat(false);
        em.merge(ad);
        if(ad.equals(null)) {
            msg="The operation to delete a member was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to delete a member was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }
}
