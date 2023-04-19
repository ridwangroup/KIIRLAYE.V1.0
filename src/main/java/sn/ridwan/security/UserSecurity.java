package sn.ridwan.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.exception.UserException;
import sn.ridwan.ipm.model.User;


import java.util.List;

@ApplicationScoped
@Path("/security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserSecurity  {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String username = user.getEmail();
        String password = user.getPassword();
        Long id = user.getId();
        boolean authenticated = authentification(username, password);
       /* if (authenticated) {
            String token = generateToken(id);
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }*/
        return Response.ok(authenticated).build();
    }

    public boolean authentification(String username,String password) {
        TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password", User.class);
        typedQuery.setParameter("email", username);
        typedQuery.setParameter("password", password);
        try{
            User u = typedQuery.getSingleResult();
            System.out.println("getSingleResult : "+u);
            return true;
        }catch(jakarta.persistence.NoResultException e) {
            return false;
        }
    }

}
