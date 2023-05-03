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
import sn.ridwan.ipm.model.Adherent;
import java.sql.SQLException;
import java.util.List;


@Path("/users/adherents")
@RequestScoped
public class AdherentController {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List adherentsList = cp.getAll("Adherent.findAll");
        if(adherentsList.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
        }
       // return Response.status(Response.Status.OK).entity("The operation of displaying all members was successful").build();
        return Response.ok(adherentsList).build();
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
        return Response.ok(result ).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Adherent ad){
        Object result = cp.create(ad);
        if(result.equals(null)) {
            return  Response.status(Response.Status.NOT_FOUND).entity("The operation to create a member was not successful ").build();

        }
        return Response.status(Response.Status.CREATED).entity("The operation to create a member was successfully completed ").build();

    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Adherent ad) {
        ad.setId(id);
        em.merge(ad);
        if(ad.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update a member was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update a member was successful completed ").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        Adherent ad = em.find(Adherent.class, id);
        em.remove(ad);
        if(ad.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete a member was not successful ").build();
        }
        return Response.status(Response.Status.OK).entity("The operation to delete a member was successful completed ").build();
    }

   /* @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object update(@PathParam("id") Long id,Adherent ad) {
      Object result= cp.update(id,ad);
      return Response.ok(result).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object remove(@PathParam("id") Long id){
      Adherent ad = (Adherent) cp.delete(id);
      return Response.ok(ad).build();
    }*/

}
