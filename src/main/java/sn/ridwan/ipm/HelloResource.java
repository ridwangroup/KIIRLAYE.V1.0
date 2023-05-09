package sn.ridwan.ipm;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import sn.ridwan.security.authorization.Secured;

import javax.annotation.security.PermitAll;

@Path("/ridwan")
//@PermitAll
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Bienvenue sur KIIRAYE!";
    }
}