package us.cijian.autumn.plugins.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import us.cijian.autumn.bean.AppCache;

import java.util.List;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class MenuMappingModelEx implements TemplateMethodModelEx {
    public Object exec(List list) throws TemplateModelException {
        return AppCache.get("menusMapping");
    }
}
