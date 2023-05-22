package sn.ridwan.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
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

    @Inject
    UserSecurityImpl usi;

    @Context
    private HttpServletRequest httpRequest;

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

}
