package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.services.implement.CrudRepository;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;

import java.util.List;


@RequestScoped
@Log
@Path("/users")
public class UserController extends CrudRepository<User> {
    @Inject
    CrudImpl cp;

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
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
