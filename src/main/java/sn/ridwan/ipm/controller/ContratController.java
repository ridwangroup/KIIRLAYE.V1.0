package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Contrat;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.List;

@Log
@Path("/entreprises/contrats")
@RequestScoped
public class ContratController {
    String msg ="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @Inject
    CrudImpl cp;

    @GET
    //@Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List offreList = cp.getAll("Contrat.findAll");
        if(offreList.equals(null)) {
            msg="The display operation of the all contrats does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(offreList).build();
    }

    @GET
    //@Secured
    @Path("/actif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllActif(){
        List offreList = cp.getAll("ContratActif.findAll");
        if(offreList.equals(null)) {
            msg="The display operation of the all actif contrats does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(offreList).build();
    }

    @GET
    //@Secured
    @Path("/inactif")
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllInActif(){
        List offreList = cp.getAll("ContratInActif.findAll");
        if(offreList.equals(null)) {
            msg="The display operation of the all inactif contrats does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(offreList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        Object result = em.find(Contrat.class,id);
        if(result.equals(null)) {
            msg="The display operation of the contrat with this id does not exist ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        return Response.ok(result).build();
    }

    @POST
    //@Secured
    @Log
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Contrat contrat){
        Object result = cp.create(contrat);
        if(result.equals(null)) {
            msg="The operation to create a contrat was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to create a contrat was successfully completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @PUT
    @Log
    //@Secured
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Contrat contrat) {
        contrat.setId(id);
        em.merge(contrat);
        if(contrat.equals(null)) {
            msg="The operation to update a contrat was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to update a contrat was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }

    @DELETE
    @Log
    //@Secured
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Contrat contrat = em.find(Contrat.class, id);
        contrat.setEtatContrat(false);
        em.merge(contrat);
        if(contrat.equals(null)) {
            msg="The operation to delete a contrat was not successful ";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        msg="The operation to delete a contrat was successful completed ";
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
    }
}
