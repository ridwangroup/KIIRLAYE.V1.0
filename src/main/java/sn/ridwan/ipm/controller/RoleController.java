//package sn.ridwan.ipm.controller;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import sn.ridwan.ipm.model.Role;
//import sn.ridwan.ipm.services.implement.CrudImpl;
//import sn.ridwan.security.log.Log;
//
//import java.sql.SQLException;
//import java.util.List;
//
//
//@Log
//@Path("/roles")
//@RequestScoped
//public class RoleController {
//
//    String msg ="";
//    @PersistenceContext(unitName="Ridwan")
//    private EntityManager em;
//
//    @Inject
//    CrudImpl cp;
//
//    @GET
//    //@Secured
//    @Log
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response findAll(){
//        List roleList = cp.getAll("Role.findAll");
//        if(roleList.equals(null)) {
//            msg="The display operation of the all roles does not exist ";
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//        }
//        return Response.ok(roleList).build();
//    }
//
//    @GET
//    //@Secured
//    @Log
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Object findById(@PathParam("id") Long id){
//        Object result = em.find(Role.class,id);
//        if(result.equals(null)) {
//            msg="The display operation of the role with this id does not exist ";
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//        }
//        return Response.ok(result).build();
//    }
//
//    @POST
//    //@Secured
//    @Log
//    @Path("/add")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Object add(Role role){
//        Object result = cp.create(role);
//        if(result.equals(null)) {
//            msg="The operation to create a role was not successful ";
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//        }
//        msg="The operation to create a role was successfully completed ";
//        return Response.status(Response.Status.OK).entity("{\"message\": \"" + msg + "\"}").build();
//    }
//
//    @PUT
//    @Log
//    //@Secured
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Response update(@PathParam("id") Long id, Role role) {
//        role.setId(id);
//        em.merge(role);
//        if(role.equals(null)) {
//            msg="The operation to update a role was not successful ";
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//        }
//        msg="The operation to update a role was successful completed ";
//        return Response.status(Response.Status.CREATED).entity("{\"message\": \"" + msg + "\"}").build();
//    }
//
//    @DELETE
//    @Log
//    //@Secured
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Response delete(@PathParam("id") Long id)throws SQLException {
//        Role role = em.find(Role.class, id);
//        role.setEtatRole(false);
//        em.merge(role);
//        if(role.equals(null)) {
//            msg="The operation to delete a praticicen was not successful ";
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//        }
//        msg="The operation to delete a role was successful completed ";
//        return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"" + msg + "\"}").build();
//    }
//
//}
