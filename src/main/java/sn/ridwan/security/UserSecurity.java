package sn.ridwan.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.log.Log;
import sn.ridwan.security.service_security_impl.UserSecurityImpl;

import static sn.ridwan.security.helpers.ValidatorHelper.HashPlainPassword;

@Log
@Path("/security")
@RequestScoped
public class UserSecurity {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    UserSecurityImpl usi;

        @POST
        @Log
        @Path("/login")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Transactional
        public Response Connexion(User user) {
        String username = user.getLogin();
        String pwd = user.getPassword();
        //Cette fonction return un token si la connection a reussie | sinon UNAUTHORIZED(401)
           String isAuthenticated = usi.authentification(username,pwd);
           if(isAuthenticated==null){
               return Response.status(Response.Status.UNAUTHORIZED).build();
           }
        return Response.ok("{\"token\": \"" + isAuthenticated + "\"}").build();
    }

    @PATCH
    @Path("/{id}/password")
    @Log
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updatePassword(@PathParam("id") Long id, User user) {
        String newPassword = user.getPassword();
        // Retrieve the user from the database based on the ID
         user = em.find(User.class,id);
        if (user == null || newPassword.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Hash and update the new password
        String hashedPassword = HashPlainPassword(newPassword);
        user.setPassword(hashedPassword);

        // Update the user in the database
        User updateSuccess = em.merge(user);
        if (updateSuccess==null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).build();
    }
}

