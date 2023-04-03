package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sn.ridwan.ipm.exception.AdherentException;
import sn.ridwan.ipm.model.Adherent;

import java.util.List;
@ApplicationScoped
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdherentController {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

        @GET
        @Path("adherent")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public List<Adherent> getUsers(){
            try {
                TypedQuery<Adherent> query = em.createQuery("SELECT ad FROM Adherent ad",Adherent.class);
                return query.getResultList();
            } catch (AdherentException e){
                System.out.println(e);
                return (List<Adherent>) e;
            }
        }
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Adherent getUserById(@PathParam("id") Long id){
            return em.find(Adherent.class,id);
        }
}
