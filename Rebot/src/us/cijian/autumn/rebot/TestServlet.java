package us.cijian.autumn.rebot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MurphyL on 6/7/2015.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        if(q == "q"){
            writer.write("[\"Bradley\", \"Greer\", \"Software Engineer\", \"London\", \"13th Oct 12\", \"$132,000\"]");
        } else {
            writer.write("[\"Brenden\", \"Wagner\", \"Software Engineer\", \"San Francisco\", \"7th Jun 11\", \"$206,850\"]");
        }
    }
}
