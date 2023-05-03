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
import sn.ridwan.ipm.model.EntrepriseClient;
import java.sql.SQLException;
import java.util.List;
@RequestScoped
@Path("/entreprise")
public class EntrepriseController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    CrudImpl cp;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
            List entrepriseClientsList = cp.getAll("EntrepriseClient.findAll");
            if(entrepriseClientsList.equals(null)) {
                return Response.status(Response.Status.NOT_FOUND).entity("The display operation of the all members does not exist  ").build();
            }
            // return Response.status(Response.Status.OK).entity("The operation of displaying all members was successful").build();
            return Response.ok(entrepriseClientsList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getById(@PathParam("id") Long id)throws SQLException {
        Object result = em.find(EntrepriseClient.class,id);
        return Response.ok(result).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object add(EntrepriseClient ec){
        Object result = cp.create(ec);
        //System.out.println("Object result : "+result);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, EntrepriseClient ec) {
        ec.setId(id);
        em.merge(ec);
        return Response.ok(ec).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id)throws SQLException {
        EntrepriseClient ec = em.find(EntrepriseClient.class, id);
        em.remove(ec);
        return  Response.ok(ec).build();
    }

 /*   @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createEC(EntrepriseClient ec) {
        em.persist(ec);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEC() {
        TypedQuery<EntrepriseClient> query = em.createQuery("SELECT ec FROM EntrepriseClient ec",EntrepriseClient.class);
        return Response.ok(query.getResultList()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EntrepriseClient getUserById(@PathParam("id") Long id)throws SQLException {
        return em.find(EntrepriseClient.class,id);
    }*/



}
