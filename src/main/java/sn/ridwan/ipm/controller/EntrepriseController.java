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
import sn.ridwan.ipm.model.EntrepriseClient;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@Log
@Path("/entreprises")
@RequestScoped
public class EntrepriseController {
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
            List entrepriseClientsList = cp.getAll("EntrepriseClient.findAll");
            if(entrepriseClientsList.equals(null)) {
                msg="The display operation of the all EntrepriseClient does not exist ";
                return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
            }
            return Response.ok(entrepriseClientsList).build();
    }
    @GET
    // @Secured
    @Path("/actif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllActif(){
        List entrepriseClientsList = cp.getAll("EntrepriseClientActif.findAll");
        if(entrepriseClientsList.equals(null)) {
            msg="The display operation of the all actif EntrepriseClient does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(entrepriseClientsList).build();
    }

    @GET
    // @Secured
    @Path("/inactif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllInActif(){
        List entrepriseClientsList = cp.getAll("EntrepriseClientInActif.findAll");
        if(entrepriseClientsList.equals(null)) {
            msg="The display operation of the all inactif EntrepriseClient does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(entrepriseClientsList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getById(@PathParam("id") Long id)throws SQLException {
        Object entrepriseClientsList = em.find(EntrepriseClient.class,id);
        if(entrepriseClientsList.equals(null)) {
            msg="The display operation of the EntrepriseClient with this id does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(entrepriseClientsList).build();
    }

    @POST
    //@Secured
    @Log
    @Path("/agent/{agent_id}/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(@PathParam("agent_id") Long agent_id,EntrepriseClient ec){
        ec.setCreateBy(new Agent(agent_id));
        ec.setUpdateBy(agent_id);
        Object entrepriseClientsList = cp.create(ec);
        if(entrepriseClientsList.equals(null)) {
            msg="The operation to create a EntrepriseClient was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create a EntrepriseClient was successfully completed ";
        return Response.status(Response.Status.OK).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
   // @Secured
    @Log
    @Path("/{id}/agent/{agent_id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, @PathParam("agent_id") Long agent_id,EntrepriseClient ec) {
        ec.setUpdateBy(agent_id);
        ec.setUpdatedAt(new Date());
        ec.setId(id);
        em.merge(ec);
        if(ec.equals(null)) {
            msg="The operation to update a EntrepriseClient was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update a EntrepriseClient was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("{id}/agent/{agent_id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id,@PathParam("agent_id") Long agent_id)throws SQLException {
        EntrepriseClient ec = em.find(EntrepriseClient.class, id);
        ec.setUpdateBy(agent_id);
        ec.setUpdatedAt(new Date());
        ec.setEtatEntreprise(false);
        em.merge(ec);
        if(ec.equals(null)) {
            msg="The operation to delete a EntrepriseClient was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to delete a EntrepriseClient was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }
}