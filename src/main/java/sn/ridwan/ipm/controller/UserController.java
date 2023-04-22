package sn.ridwan.ipm.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.exception.UserException;
import sn.ridwan.ipm.model.User;

import java.sql.SQLException;

@ApplicationScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsers()throws SQLException {
        TypedQuery<User> query = em.createQuery("SELECT user FROM User user",User.class);
        return Response.ok(query.getResultList()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id)throws SQLException{
        User us = em.find(User.class,id);
        return Response.ok(us).build();
    }
}
