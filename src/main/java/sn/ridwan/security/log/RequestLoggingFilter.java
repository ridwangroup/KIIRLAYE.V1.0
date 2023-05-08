package sn.ridwan.security.log;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.logging.Logger;

import java.util.Locale;

@Provider
@Log
public class RequestLoggingFilter implements ContainerRequestFilter {
    private static final Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName().getClass());

    @Override
    public void filter(ContainerRequestContext crc) {
       // System.out.println("test Log :"+crc.getMethod() + " " + crc.getUriInfo().getAbsolutePath());
        for (String key : crc.getHeaders().keySet()) {
            logger.info("[REST Logging] " +key + ": " + crc.getHeaders().get(key));
            //logger.info("[REST Logging] " +key + ": " + crc.getMethod().toUpperCase(Locale.ROOT));
            //logger.info("[REST Logging] " +key + ": " + crc.getDate()+"");
            //logger.info("[REST Logging] " +key + ": " + crc.getMediaType() +"");
           // logger.info("[REST Logging] " +key + ": " +crc.getMethod() + " " + crc.getUriInfo().getAbsolutePath());
        }
    }
}