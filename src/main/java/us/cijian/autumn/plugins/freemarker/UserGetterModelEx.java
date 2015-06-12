package us.cijian.autumn.plugins.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.shiro.SecurityUtils;

import java.util.List;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class UserGetterModelEx implements TemplateMethodModelEx {
    public Object exec(List list) throws TemplateModelException {
        return SecurityUtils.getSubject();
    }
}
