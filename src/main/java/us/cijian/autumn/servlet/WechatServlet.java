package us.cijian.autumn.servlet;

import us.cijian.autumn.config.Wechat;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.utils.MessageUtils;
import us.cijian.autumn.utils.SignUtils;
import us.cijian.autumn.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by luohao4 on 2015/3/19.
 */
public class WechatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        dealGetRequest(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        dealPostRequest(req, res);
    }

    private void dealGetRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");
        PrintWriter out = res.getWriter();
        if (StringUtils.isBlank(signature)) {
            for (Wechat wechat : Wechat.values()) {
                out.println(wechat.name() + " : " + wechat.getVal());
            }
            return;
        }
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
    }

    public void dealPostRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String msg = req.getParameter("msg");
        try {
            Message message = MessageUtils.xml2Bean(Message.class, msg);
            if (null == message) {
                return;
            }
            if (message.is(Message.Type.text)) {
                Message response = new TextMessage();
                response.setFromUserName(message.getToUserName());
                response.setToUserName(message.getFromUserName());
                response.setContent("Hello world");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
