package us.cijian.autumn.handler;

import freemarker.template.Configuration;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.config.Resource;
import us.cijian.autumn.utils.SignUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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

    public void response(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        response.setCharacterEncoding(Project.ENCODING);
        try {
            Resource template;
            if (uri.length() > 1) {
                template = Resource.valueOf(dealUri(uri));
            } else {
                template = Resource.INDEX;
            }
            write(request.getRequestURL(), template, response.getWriter());
        } catch (IOException e) {
            response.setStatus(500);
        } catch (IllegalArgumentException e) {
            response.setStatus(404);
        }
    }

    private final String dealUri(String uri) {
        return uri.toUpperCase().substring(1).replace("/", "_");
    }

    private final void write(StringBuffer url, Resource res, PrintWriter pr) {
        try {
            String fileName = getFileName(res);
            config.setSharedVariable("wxCfg", SignUtils.getShareConfig(url.toString()));
            config.getTemplate(fileName).process(null, pr);
        } catch (Exception e) {
            pr.println("<h1>500</h1>");
        }
    }

    public String getFileName(Resource res) {
        return res.name().toLowerCase() + ".ftl";
    }

}
