package us.cijian.autumn.module;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import us.cijian.autumn.exception.NoPrivilegesException;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class SecuredInterceptor implements MethodInterceptor {


    public Object invoke(MethodInvocation mi) throws Throwable {
        String roleName = null;
        if(mi.getMethod().isAnnotationPresent(Role.class)){
            Role role = mi.getMethod().getDeclaredAnnotation(Role.class);
            roleName = role.value().name();
        } else if(mi.getThis().getClass().isAnnotationPresent(Role.class)) {
            Role role = mi.getThis().getClass().getDeclaredAnnotation(Role.class);
            roleName = role.value().name();
        }
        if(StringUtils.isNoneBlank(roleName)){
            Subject user = SecurityUtils.getSubject();
            if(!user.hasRole(roleName)){
                throw new NoPrivilegesException(user.isAuthenticated());
            }
        }
        return mi.proceed();
    }
}
