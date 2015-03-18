package us.cijian.autumn.config;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Murphy on 3/19/2015.
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface Inject {
}
