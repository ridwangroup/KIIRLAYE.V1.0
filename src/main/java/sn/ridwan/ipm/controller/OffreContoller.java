package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Offre;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.List;

@Log
@Path("/entreprises/offres")
@RequestScoped
public class OffreContoller {

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
        List offreList = cp.getAll("Offre.findAll");
        if(offreList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all offres does not exist  ").build();
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
        Object result = em.find(Offre.class,id);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the member with this id does not exist ").build();
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
    public Object add(Offre offre){
        Object result = cp.create(offre);
        if(result.equals(null)) {
            return  Response.status(Response.Status.NOT_FOUND).entity("The operation to c  reate a member was not successful ").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to create a member was successfully completed ").build();

    }

    @PUT
    @Log
    //@Secured
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Offre offre) {
        offre.setId(id);
        em.merge(offre);
        if(offre.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a member was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a member was successful completed ").build();
    }

    @DELETE
    @Log
    //@Secured
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Offre offre = em.find(Offre.class, id);
        offre.setEtatOffre(false);
        em.merge(offre);
        if(offre.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a member was not successful ").build();
        }
        return Response.status(Response.Status.OK).entity("The operation to delete a member was successful completed ").build();
    }
}
