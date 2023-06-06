package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Adresse;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.List;

@Log
@Path("/adresses")
@RequestScoped
public class AdresseController {
    String msg="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
    //@Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
        msg="The display operation of the all adresse does not exist  ";
        List agentsList = cp.getAll("Adresse.findAll");
        if(agentsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(agentsList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        msg="The operation to update a adresse was not successful";
        Object result = cp.getById(id);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(result).build();
    }

    @POST
   // @Secured
    @Log
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Adresse adr){
        msg="The operation to create Adresse was not successful";
        Object result = cp.create(adr);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create was successful completed ";
        return Response.status(Response.Status.OK).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Adresse adr) {
        adr.setId(id);
        em.merge(adr);
        if(adr.equals(null)) {
            msg="The operation to update Adresse was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update Adresse was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Adresse adr = em.find(Adresse.class, id);
        adr.setEtatAdresse(false);
        em.merge(adr);
        if(adr.equals(null)) {
            msg="The operation to delete Adresse was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to delete Adresse was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }
}
