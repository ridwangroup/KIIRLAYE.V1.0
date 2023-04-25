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
import java.sql.SQLException;



@ApplicationScoped
@Path("/users/adherents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AdherentController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response getUsers() {
            TypedQuery<Adherent> query = em.createQuery("SELECT ad FROM Adherent ad",Adherent.class);
            return Response.ok(query.getResultList()).build();
        }
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response getUserById(@PathParam("id") Long id)throws SQLException{
            Adherent ad = em.find(Adherent.class,id);
            return Response.ok(ad).build();
        }

        @PUT
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateUser(@PathParam("id") Long id, Adherent ad) {
            ad.setId(id);
            em.merge(ad);
        }

        @DELETE
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteUser(@PathParam("id") Long id)throws SQLException {
            Adherent ad = em.find(Adherent.class, id);
            em.remove(ad);
            return  Response.ok(ad).build();
        }
}
