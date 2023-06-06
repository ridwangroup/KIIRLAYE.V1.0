package sn.ridwan.security.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.logging.Logger;
import sn.ridwan.ipm.model.User;

import java.time.LocalDateTime;

@Provider
@Log
public class RequestLoggingFilter implements ContainerRequestFilter {
    private static final Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName().getClass());
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Override
    @Transactional
    public void filter(ContainerRequestContext requestContext) {
        // Get request details
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getRequestUri().toString();
        LocalDateTime timestamp = LocalDateTime.now();
        User user = new User();

        // Create log entry
        RequestLog requestLog = new RequestLog();
        requestLog.setMethod(method);
        requestLog.setPath(path);
        requestLog.setTimestamp(timestamp);
        //requestLog.setCreateAtBy(new User(user.getId()));

        // Persist log entry to the database
        em.persist(requestLog);


       // System.out.println("###########@@@@@@@@##########\n :"+ requestContext.getClass()+"\n###########@@@@@@@@##########");
        for (String key : requestContext.getHeaders().keySet()) {
            logger.info("[RIDWAN Logging] " +key + ": " + requestContext.getHeaders().get(key));
            //logger.info("[REST Logging] " +key + ": " + crc.getMethod().toUpperCase(Locale.ROOT));
            //logger.info("[REST Logging] " +key + ": " + crc.getDate()+"");
            //logger.info("[REST Logging] " +key + ": " + crc.getMediaType() +"");
           // logger.info("[REST Logging] " +key + ": " +crc.getMethod() + " " + crc.getUriInfo().getAbsolutePath());
        }
    }

}