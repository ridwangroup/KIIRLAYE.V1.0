package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.Service_ipm_impl.CrudImpl;
import java.util.List;

@RequestScoped
@Path("/users")

public class UserController {
    @Inject
    CrudImpl cp;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll(){
        List usersList = cp.getAll("User.findAll");
        return Response.ok(usersList).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Object findById(@PathParam("id") Long id){
        Object result = cp.getById(id);
        return Response.ok(result).build();
    }

}
