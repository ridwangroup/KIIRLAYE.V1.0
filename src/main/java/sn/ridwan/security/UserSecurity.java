package sn.ridwan.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.log.Log;
import sn.ridwan.security.service_security_impl.UserSecurityImpl;
import sn.ridwan.security.sessions.SessionAttributeRepository;

import static sn.ridwan.security.helpers.ValidatorHelper.HashPlainPassword;
import static sn.ridwan.security.helpers.ValidatorHelper.milliSecond;

@Log
@Path("/security")
@RequestScoped
public class UserSecurity {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Inject
    UserSecurityImpl usi;

    @Inject
    SessionAttributeRepository sessionAttributeRepository;

    @Context
    HttpServletResponse response;

    @Context
    HttpServletRequest request;

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
           String returnId = usi.returnId(username,pwd);
           boolean isFirstConnection =usi.returnFirstConnexion(username);
           String lt =usi.returnLoginType(username);
            System.out.println("##############################################\n isFirstConnection : "+isFirstConnection);
           if(isAuthenticated==null){
               return Response.status(Response.Status.UNAUTHORIZED).build();
           }
           String msg = "{\"isFirstConnection\": \"" + true + "\"," + "\"userId\": \"" + returnId + "\"}";
           if(isFirstConnection){
               //String msg = "This is your first connection...! Please change your password before you can continue...!";
               return Response.ok(msg).build();
           }
           sessionAttributeRepository.storeSessionAttribute(lt,username, usi.returnId(username,pwd));
            return Response.ok("{\"isFirstConnection\": \"" + false + "\"," + "\"token\": \"" + isAuthenticated +" \"}").build();
            //return Response.ok("{\"token\": \"" + isAuthenticated + "\"}").build();

            //return  Response.ok(isAuthenticated).build();
           /* response.addCookie(
                    new Cookie("token",isAuthenticated)
            );
            Cookie[] cookies = request.getCookies();
            // Check if cookies exist
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                   // String name = cookie.getName();
                    String value = cookie.getValue();
                    // Process the cookie data as needed
                    return Response.ok("{\"token\": \"" + value + "\"," + "\"isFirstConnection\": \"" + false +" \"}").build();
                }
            }
            return null;*/
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


        @PUT
        @Path("/{id}/firstConnection")
        @Log
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Transactional
        public Response updateFirstConnection(@PathParam("id") Long id, User user) {
            String newPassword = user.getPassword();
            // Retrieve the user from the database based on the ID
            user = em.find(User.class,id);
            boolean firstConnection = user.isFirstConnection();
            if (newPassword.isEmpty() || !firstConnection) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            // Hash and update the new password
            String hashedPassword = HashPlainPassword(newPassword);
            user.setPassword(hashedPassword);
            user.setFirstConnection(false);
            String jwt = usi.createJWT(user.getId(),milliSecond());
            // Update the user in the database
            User updateSuccess = em.merge(user);
            if (updateSuccess==null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
            return Response.ok("{\"token\": \"" + jwt + "\"}").build();
        }
    }
