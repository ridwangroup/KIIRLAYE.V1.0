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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List offreList = cp.getAll("Contrat.findAll");
        if(offreList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all contrats does not exist  ").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the contrat with this id does not exist ").build();
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
            return  Response.status(Response.Status.NOT_FOUND).entity("The operation to create a contrat was not successful ").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to create a contrat was successfully completed ").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a contrat was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a contrat was successful completed ").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a contrat was not successful ").build();
        }
        return Response.status(Response.Status.OK).entity("The operation to delete a contrat was successful completed ").build();
    }
}
