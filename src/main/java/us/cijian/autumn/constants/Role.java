package us.cijian.autumn.constants;

import java.lang.annotation.*;

/**
 * Created by MurphyL on 5/24/2015.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Role {

    Privileges value() default Privileges.Admin;

}
