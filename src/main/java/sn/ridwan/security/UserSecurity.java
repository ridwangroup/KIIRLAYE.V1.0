package sn.ridwan.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sn.ridwan.ipm.model.Adherent;

@ApplicationScoped
@Path("security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserSecurity {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @GET
    @Path("/adherent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Adherent getUserById(@PathParam("id") Long id){
        return em.find(Adherent.class,id);
    }
}
