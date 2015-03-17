package us.cijian.autumn.handler;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import us.cijian.autumn.config.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class RequestHandler {

    private Configuration config;

    public RequestHandler(Configuration config) {
        this.config = config;
    }

    public synchronized static RequestHandler getInstance(Configuration cfg) {
        return new RequestHandler(cfg);
    }

    public void response(String uri, HttpServletResponse response) {
        PrintWriter pr = null;
        response.setCharacterEncoding("UTF-8");
        try {
            Resource template;
            pr = response.getWriter();
            if(uri.length() > 1){
                template = Resource.valueOf(dealUri(uri));
            } else {
                template = Resource.INDEX;
            }
            write(template, pr);
        } catch (IOException e) {
            response.setStatus(500);
            pr.println("<h1>500</h1>");
        } catch (IllegalArgumentException e) {
            response.setStatus(404);
            pr.println("<h1>404</h1>");
        }
    }

    private final String dealUri(String uri){
        return uri.toUpperCase().substring(1).replace("/", "_");
    }

    private final void write(Resource res, PrintWriter pr) {
        try {
            config.getTemplate(res.ftl()).process(null, pr);
        } catch (Exception e) {
            pr.println("<h1>500</h1>");
        }
    }

}
