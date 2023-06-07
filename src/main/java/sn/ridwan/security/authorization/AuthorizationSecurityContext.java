package sn.ridwan.security.authorization;

import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

public class AuthorizationSecurityContext implements SecurityContext {

    private final String token;
    private final Set<String> role;

    public AuthorizationSecurityContext(String token) {
        this.token = token;
        // Set the roles based on the token, e.g. by parsing the JWT claims
        this.role = parseRolesFromToken(token);
    }


    public Principal getUserPrincipal() {
        // Return a Principal object that represents the user associated with the token
        return () -> getUserIdFromToken(token);
    }


    public boolean isUserInRole(String role) {
        // Check if the user has the specified role, based on the roles parsed from the token
        return role.contains(role);
    }


    public boolean isSecure() {
        // Return true if the request was made over a secure connection, false otherwise
        return false;
    }


    public String getAuthenticationScheme() {
        // Return the authentication scheme used to authenticate the user, e.g. "Bearer"
        return "Bearer";
    }

    private String getUserIdFromToken(String token) {
        // Parse the user ID from the token, e.g. by decoding the JWT claims
        return String.valueOf(token.contains("jti"));
    }

    private Set<String> parseRolesFromToken(String token) {
        // Parse the roles from the token, e.g. by decoding the JWT claims
        return Collections.singleton("user");
    }


    @Override
    public Principal getCallerPrincipal() {
        return null;
    }

    @Override
    public <T extends Principal> Set<T> getPrincipalsByType(Class<T> pType) {
        return null;
    }

    @Override
    public boolean isCallerInRole(String role) {
        return false;
    }

    @Override
    public boolean hasAccessToWebResource(String resource, String... methods) {
        return false;
    }

    @Override
    public AuthenticationStatus authenticate(HttpServletRequest request, HttpServletResponse response, AuthenticationParameters parameters) {
        return null;
    }
}
