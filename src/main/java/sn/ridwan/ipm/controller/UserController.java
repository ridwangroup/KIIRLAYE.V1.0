package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Role;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.authorization.SecuredRole;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.sessions.Session;

import java.util.List;

@RequestScoped
@Log
@Path("/users")
public class UserController {
    @Inject
    CrudImpl cp;
        @GET
        @Log
        @Secured
        //@SecuredRole({Role.AGENT})
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        @Transactional
        public Response findAll(){
            List usersList = cp.getAll("User.findAll");
            return Response.ok(usersList).build();
        }
        @GET
        @Log
        @Secured
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        @Transactional
        public Object findById(@PathParam("id") Long id){
            Object result = cp.getById(id);
            return Response.ok(result).build();
        }

}
