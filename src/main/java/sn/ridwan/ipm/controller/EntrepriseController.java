package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Adherent;
import sn.ridwan.ipm.model.Agent;
import sn.ridwan.ipm.model.EntrepriseClient;

import java.sql.SQLException;

@ApplicationScoped
@Path("/entrepise")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class EntrepriseController {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;


    @POST
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
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEC(@PathParam("id") Long id, EntrepriseClient ec) {
        ec.setId(id);
        em.merge(ec);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEC(@PathParam("id") Long id)throws SQLException {
        EntrepriseClient ec = em.find(EntrepriseClient.class, id);
        em.remove(ec);
        return  Response.ok(ec).build();
    }

}
