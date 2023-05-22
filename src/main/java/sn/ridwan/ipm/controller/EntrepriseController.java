package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.ipm.model.EntrepriseClient;
import java.sql.SQLException;
import java.util.List;

@RequestScoped
@Log
@Path("/entreprise")
public class EntrepriseController {
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
                return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the EntrepriseClient with this id does not exist ").build();
        }
        return Response.ok(entrepriseClientsList).build();
    }

    @POST
    //@Secured
    @Log
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(EntrepriseClient ec){
        Object entrepriseClientsList = cp.create(ec);
        if(entrepriseClientsList.equals(null)) {
            return  Response.status(Response.Status.NOT_FOUND).entity("The operation to create a EntrepriseClient was not successful ").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to create a EntrepriseClient was successfully completed ").build();
    }

    @PUT
   // @Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, EntrepriseClient ec) {
        ec.setId(id);
        em.merge(ec);
        if(ec.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a EntrepriseClient was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a EntrepriseClient was successful completed ").build();
    }

    @DELETE
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        EntrepriseClient entrepriseClientsList = em.find(EntrepriseClient.class, id);
        em.remove(entrepriseClientsList);
        if(entrepriseClientsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a EntrepriseClient was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to delete a EntrepriseClient was successful completed ").build();

    }

}
