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
    @Inject
    CrudImpl cp;

        @GET
        @Log
       // @Secured
        //@SecuredRole({Role.AGENT})
        @Produces(MediaType.APPLICATION_JSON)
        public Response findAlle(){
            List usersList = cp.getAll("User.findAll");
            return Response.ok(usersList).build();
        }
        @GET
        @Log
       // @Secured
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response findById(@PathParam("id") Long id){
            Object result = cp.getById(id);
            return Response.ok(result).build();
        }

}
