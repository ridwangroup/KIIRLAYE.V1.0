package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.logging.Logger;
import sn.ridwan.ipm.exception.AdherentException;
import sn.ridwan.ipm.model.Adherent;
import java.util.List;


@ApplicationScoped
@Path("/users/adherents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AdherentController {
    static Adherent ads;
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    static Logger logger= Logger.getLogger(Adherent.class);
    static {
        logger.info("Initializing Internal DataStore...");
    }
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public List<Adherent> getUsers(){
            logger.info("Getting all Adherents...");
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
            logger.info("Get Adherents ById..."+"id>"+id);
            Long ad = ads.getId();
            if (ad != null) {
                logger.info("Inside getAdherentById, returned: "
                        + ad.toString());
            }
            return em.find(Adherent.class,id);
        }
        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateUser(@PathParam("id") Long id, Adherent user) {
            logger.info("Updating Adherents...");
            user.setId(id);
            em.merge(user);
        }

        @DELETE
        @Path("/{id}")
        public void deleteUser(@PathParam("id") Long id) {
            logger.info("Remove all Adherents...");
            Adherent user = em.find(Adherent.class, id);
            em.remove(user);
        }
}
