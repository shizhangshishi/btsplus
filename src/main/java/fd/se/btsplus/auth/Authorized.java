package fd.se.btsplus.auth;

import fd.se.btsplus.model.consts.Role;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorized {
    Role[] roles = {};
}
