package sn.ridwan.security;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.log.Log;
import sn.ridwan.security.service_security_impl.UserSecurityImpl;
import sn.ridwan.security.sessions.Session;

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
    public Response login(User user) {

        String login = user.getLogin();
        String password = user.getPassword();

        //Cette fonction return True si la connection a reussie | sinon False
        boolean isAuthenticated = usi.authentification(login, password);
        if (!isAuthenticated) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        long  userId = usi.getUserByLoginById(login);
        String token = usi.createJWT(userId,60000);
        return Response.ok("{\"token\": \"" + token + "\"}").build();
    }



}
