package us.cijian.autumn.module;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import us.cijian.autumn.exception.NoPrivilegesException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) {
        if (e.getCause() instanceof NoPrivilegesException) {
            final NoPrivilegesException npe = (NoPrivilegesException) e.getCause();
            return new ModelAndView("common/no.privileges", new HashMap<String, Object>(){{
                this.put("authenticated", npe.isAuthenticated());
            }});
        }
        return new ModelAndView("common/system.error");
    }
}
