package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.dto.AdresseDto;
import sn.ridwan.ipm.mapper.AdresseMapper;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.ipm.model.Adresse;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Path("/adresses")
@RequestScoped
public class AdresseController {
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
        List agentsList = cp.getAll("Adresse.findAll");
        return Response.ok(agentsList).build();
    }

    @GET
    //@Secured
    @Log
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        Object result = cp.getById(id);
        return Response.ok( result).build();
    }

    @POST
   // @Secured
    @Log
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(Adresse adr){
        Object result = cp.create(adr);
        if(result.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to create Adresse was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update create was successful completed ").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to update Adresse was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to update Adresse was successful completed ").build();
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
        em.remove(adr);
        if(adr.equals(null)) {
            return Response.status(Response.Status.NOT_FOUND).entity("The operation to delete Adresse was not successful").build();
        }
        return Response.status(Response.Status.CREATED).entity("The operation to delete Adresse was successful completed ").build();
    }
}
