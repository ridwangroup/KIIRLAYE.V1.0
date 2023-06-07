package sn.ridwan.security.authorization;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import sn.ridwan.ipm.model.Role;
import sn.ridwan.ipm.model.User;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SecuredRole
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilterRole implements ContainerRequestFilter {

    @Inject
    HttpServletRequest request;
    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<Role> classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);

        try {

            // Check if the user is allowed to execute the method
            // The method annotations override the class annotations
            if (methodRoles.isEmpty()) {
                System.out.println("methodRoles is empty : "+methodRoles);
                checkPermissions(classRoles);
            } else {
                System.out.println("checkPermissions(methodRoles) is exist : "+methodRoles);
                checkPermissions(methodRoles);
            }

        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.FORBIDDEN).build());
        }
    }

    // Extract the roles from the annotated element
    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            System.out.println("annotatedElement is Null : "+annotatedElement);
            return new ArrayList<Role>();
        } else {
            SecuredRole secured = annotatedElement.getAnnotation(SecuredRole.class);
            System.out.println("Secure if exist : "+secured);
            if (secured == null) {
                System.out.println("SecuredRole Not Null : "+secured);
                return new ArrayList<Role>();
            } else {
                Role[] allowedRoles = secured.value();
                System.out.println("allowedRoles  : "+allowedRoles);
                return Arrays.asList(allowedRoles);
            }
        }
    }

   /* private void checkPermissions(List<Role> allowedRoles) throws Exception {
        User userRole = new User();
        String us = String.valueOf(userRole.getRoles());
        allowedRoles.add(Role.valueOf(us));
        System.out.println("checkPermissions : "+us);


        // Check if the user contains one of the allowed roles
        // Throw an Exception if the user has not permission to execute the method
    }*/

   public boolean checkPermissions(List<Role> allowedRoles) {
        List<Role> userRoles = getCurrentUserRoles(); // get the roles of the current user

        // Check if the user has any of the allowed roles
        for (Role allowedRole : allowedRoles) {
            if (userRoles.contains(allowedRole)) {
                return true; // user has the necessary role
            }
        }

        return false; // user does not have the necessary role
    }
    public List<Role> getCurrentUserRoles() {
        HttpSession session = request.getSession(false); // retrieve the current session without creating a new one
        if (session != null) {
            User currentUser = (User) session.getAttribute("currentUser"); // retrieve the current user object from the session
            if (currentUser != null) {
                return currentUser.getRoles(); // return the user's roles
            }
        }
        return new ArrayList<>(); // return an empty list if the user is not logged in or has no roles
    }

}
