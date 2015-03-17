package us.cijian.autumn.servlet;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import us.cijian.autumn.handler.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class AutumnServlet extends HttpServlet {

    private Configuration cfg;

    @Override
    public void init() throws ServletException {
        if (cfg == null) {
            cfg = new Configuration();
            try {
                cfg.setLocale(Locale.CHINA);
                cfg.setSetting("defaultEncoding", "UTF-8");
                cfg.setSetting("datetime_format", "yyyy-MM-dd HH:mm:ss");
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            cfg.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/classes/main/resources/template");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(req, res, cfg).response();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(req, res, cfg).response();
    }
}
