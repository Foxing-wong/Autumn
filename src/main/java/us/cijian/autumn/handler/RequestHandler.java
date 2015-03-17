package us.cijian.autumn.handler;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import us.cijian.autumn.config.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class RequestHandler {

    private Configuration config;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public RequestHandler(HttpServletRequest request, HttpServletResponse response, Configuration config) {
        this.config = config;
        this.request = request;
        this.response = response;
    }

    public synchronized static RequestHandler getInstance(HttpServletRequest req, HttpServletResponse res, Configuration cfg) {
        res.setCharacterEncoding("UTF-8");
        return new RequestHandler(req, res, cfg);
    }

    public void response() {
        String uri = request.getRequestURI().toUpperCase();
        Resource template = null;
        if(uri.length() > 1){
            try {
                template = Resource.valueOf(dealUri(uri));
            } catch (IllegalArgumentException e) {
                response.setStatus(404);
            }
        } else {
            template = Resource.INDEX;
        }
        try {
            out(template);
        } catch (TemplateException e) {
            response.setStatus(503);
        } catch (IOException e) {
            response.setStatus(500);
        }
    }

    private final String dealUri(String uri){
        return uri.substring(1).replace("/", "_");
    }

    private final void out(Resource res) throws IOException, TemplateException {
        config.getTemplate(res.ftl()).process(null, response.getWriter());
    }

}
