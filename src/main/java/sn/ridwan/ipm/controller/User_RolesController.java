package sn.ridwan.ipm.controller;


import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.security.log.Log;

@RequestScoped
@Log
@Path("/users/roles")
public class User_RolesController {
    String msg="";
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @GET
    // @Secured
    @Log
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        //Query namedQuery = em.createNamedQuery("UserRoles.findAll");
       // namedQuery.getResultList();
       // List userList = namedQuery.getResultList();
       // if(userList.equals(null)) {
            msg="The display operation of the all UserRoles does not exist";
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
        //}
        //return Response.ok(msg).build();
    }
}
