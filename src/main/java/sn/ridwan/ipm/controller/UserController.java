package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.ipm.services.implement.CrudRepository;
import sn.ridwan.security.log.Log;

import java.util.List;


@RequestScoped
@Log
@Path("/users")
public class UserController extends CrudRepository<User> {
    String msg="";
    @Inject
    CrudImpl cp;

        @GET
        @Log
       // @Secured
        //@SecuredRole({Role.AGENT})
        @Produces(MediaType.APPLICATION_JSON)
        public Response findAlle(){
            List usersList = cp.getAll("User.findAll");
            if(usersList.equals(null)) {
                msg="The display operation of the users does not exist";
                return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
            }
            return Response.ok(usersList).build();
        }
        @GET
        @Log
       // @Secured
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response findById(@PathParam("id") Long id){
            Object result = cp.getById(id);
            if(result.equals(null)) {
                msg="The display operation of the users with this id does not exist";
                return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
            }
            return Response.ok(result).build();
        }
}
