package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sn.ridwan.ipm.exception.UserException;
import sn.ridwan.ipm.model.User;
import java.util.List;

@ApplicationScoped
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        try {
            TypedQuery<User> query = em.createQuery("SELECT user FROM User user",User.class);
            return query.getResultList();
        } catch (UserException e){
            System.out.println(e);
            return (List<User>) e;
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id){
        return em.find(User.class,id);
    }
}
