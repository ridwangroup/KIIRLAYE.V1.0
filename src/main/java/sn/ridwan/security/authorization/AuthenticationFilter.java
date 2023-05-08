package sn.ridwan.security.authorization;

import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;


/*@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";*/

  /*  @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(AUTHORIZATION_HEADER);
        System.out.println("authorizationHeader : "+authorizationHeader);

        // Check if the Authorization header is present and contains the Bearer prefix
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
            // Extract the token from the Authorization header
            String token = authorizationHeader.substring(BEARER_PREFIX.length()).trim();
            System.out.println("token exist : "+token);


            // Validate the token and set the security context
            if (isValidToken(token)) {
                SecurityContext securityContext = new AuthorizationSecurityContext(token);
                requestContext.setSecurityContext((jakarta.ws.rs.core.SecurityContext) securityContext);
                return;
            }
        }

        // If the Authorization header is missing or the token is invalid, abort the request
        Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
                .header("WWW-Authenticate", "Bearer")
                .build();
        requestContext.abortWith(unauthorizedResponse);
    }

    private boolean isValidToken(String token) {
        // Perform validation logic here, e.g. check if the token is valid and not expired
        // Return true if the token is valid, false otherwise
        return "mySecretToken".equals(token);
    }
*/
//}

