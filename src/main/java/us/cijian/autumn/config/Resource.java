package us.cijian.autumn.config;

import freemarker.template.TemplateException;
import us.cijian.autumn.utils.TemplateUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

    INDEX;

    public final void out(HttpServletResponse response) throws IOException, TemplateException {
        TemplateUtils.getInstance().render(this, response);
    }

}
