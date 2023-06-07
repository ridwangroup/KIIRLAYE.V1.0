package sn.ridwan.ipm.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {
    //Ce filtre injecte un en-tête "X-Powered-By", "RIDWAN-GROUP" sur toutes les requetes entrants/sortants
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        responseContext.getHeaders().add("X-Powered-By", "RIDWAN-GROUP :-)");
    }
}
