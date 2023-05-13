package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.dto.UserDto;
import sn.ridwan.ipm.mapper.UserMapper;
import sn.ridwan.ipm.model.Role;
import sn.ridwan.ipm.model.User;
import sn.ridwan.security.authorization.Secured;
import sn.ridwan.security.authorization.SecuredRole;
import sn.ridwan.security.log.Log;
import sn.ridwan.ipm.services.implement.CrudImpl;
import sn.ridwan.security.sessions.Session;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Log
@Path("/users")
public class UserController {
    @Inject
    CrudImpl cp;
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
        @GET
        @Log
        @Secured
        @Path("/dto")
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

        @GET
        @Log
        @Transactional
        @Produces(MediaType.APPLICATION_JSON)
        public List<UserDto> findAllUser(){
            TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
            List<User> userList = query.getResultList();
            return userList.stream().map(UserMapper.INSTANCE::userToDTO).collect(Collectors.toList());

        }

}
