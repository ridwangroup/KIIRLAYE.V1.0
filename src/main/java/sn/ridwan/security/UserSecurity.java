package sn.ridwan.security;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.log.Log;
import sn.ridwan.security.service_security_impl.UserSecurityImpl;

@Log
@Path("/security")
@RequestScoped
public class UserSecurity {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    UserSecurityImpl usi;

    @Context
    private HttpServletRequest httpRequest;

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
           // return Response.status(Response.Status.FORBIDDEN).build();
        }
        HttpSession session = httpRequest.getSession();
        session.setAttribute("login", login);
        Long userId = usi.getUserByLoginById(login).getId();
        System.out.println("###################userId : "+userId);
        String token = usi.createJWT(userId,60000);
         user.setToken(token);
        System.out.println(" userToken :"+user.getToken());
        session.setAttribute("token", token);
       // System.out.println("session.getAttribute : "+session.getAttribute(token));
        System.out.println("SessionId : "+ session.getId());
        return Response.ok("{\"token\": \"" + token + "\"}").build();
    }

}
