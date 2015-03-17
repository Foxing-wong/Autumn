package us.cijian.autumn.handler;

import freemarker.template.TemplateException;
import us.cijian.autumn.config.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class RequestHandler {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public RequestHandler(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public synchronized static RequestHandler getInstance(HttpServletRequest req, HttpServletResponse res) {
        return new RequestHandler(req, res);
    }

    public void deal() {
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
            template.out(response);
        } catch (TemplateException e) {
            response.setStatus(503);
        } catch (IOException e) {
            response.setStatus(500);
        }
    }

    private final String dealUri(String uri){
        return uri.substring(1).replace("/", "_");
    }

}
