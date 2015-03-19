package us.cijian.autumn.servlet;

import freemarker.template.Configuration;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.handler.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class AutumnServlet extends HttpServlet {

    private Configuration cfg;

    @Override
    public void init() throws ServletException {
        cfg = new Configuration();
        cfg.setServletContextForTemplateLoading(getServletContext(), Project.FTL_PATH);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(cfg).response(req.getRequestURI(), res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(cfg).response(req.getRequestURI(), res);
    }
}
