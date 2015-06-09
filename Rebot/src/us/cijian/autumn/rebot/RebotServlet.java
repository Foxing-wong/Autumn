package us.cijian.autumn.rebot;

import us.cijian.autumn.rebot.utils.TuringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用来相应 linode 服务器访问图灵机器人困难的问题
 * Created by MurphyL on 6/7/2015.
 */
public class RebotServlet extends HttpServlet {

    public static final String DEFAULT_MSG = "我以前和你一样也是个冒险家，直到我的膝盖中了一箭。";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequst(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequst(req, resp);
    }

    private void handleRequst(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer =  response.getWriter();
        String text = request.getParameter("in");
        try {
            writer.write(TuringUtils.process(text));
        } catch (Exception e) {
            writer.write(DEFAULT_MSG);
        }

    }

}
