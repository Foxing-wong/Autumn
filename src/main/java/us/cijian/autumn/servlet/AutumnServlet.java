package us.cijian.autumn.servlet;

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

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(req, res).deal();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestHandler.getInstance(req, res).deal();
    }
}
