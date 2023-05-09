package sn.ridwan.security.authorization;

import jakarta.ws.rs.NameBinding;
import sn.ridwan.ipm.model.Role;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface SecuredRole {
    Role[] value() default {};

}
