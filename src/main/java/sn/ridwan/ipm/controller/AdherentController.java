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
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.log.Log;

import java.sql.SQLException;
import java.util.List;

@Path("/users/adherents")
@Log
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
        msg="The display operation of the all members does not exist";
        List adherentsList = cp.getAll("Adherent.findAll");
        if(adherentsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
           // return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
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
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Adherent ad){
        Object result = cp.create(ad);
        if(result.equals(null)) {
            msg="The operation to create a member was not successful";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        }
        User user = new User();
        user.setEmail(ad.getAd_email());
        user.setTel(ad.getAd_tel());
        user.setUserIdd(ad.getIpmID());
        em.merge(user);

        return Response.status(Response.Status.CREATED).entity("The operation to create a member was successfully completed ").build();
    }

    @PUT
    @Log
    //@Secured
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Adherent ad) {
        msg="The operation to update a member was not successful";
        ad.setId(id);
        em.merge(ad);
        if(ad.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();

            //return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a member was not successful").build();
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
        msg="The operation to delete a member was not successful ";
        Adherent ad = em.find(Adherent.class, id);
        ad.setIsEtat(false);
        em.merge(ad);
        if(ad.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
            //return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a member was not successful ").build();
        }
        return Response.status(Response.Status.OK).entity("The operation to delete a member was successful completed ").build();
    }

}
