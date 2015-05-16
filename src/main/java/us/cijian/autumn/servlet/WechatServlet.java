package us.cijian.autumn.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.config.Wechat;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.pojo.WechatRequest;
import us.cijian.autumn.utils.MessageUtils;
import us.cijian.autumn.utils.SignUtils;
import us.cijian.autumn.utils.StringUtils;
import us.cijian.autumn.utils.TuringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Scanner;

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
        WechatRequest request = new WechatRequest(req);
        PrintWriter out = res.getWriter();
        if (StringUtils.isBlank(request.getSignature())) {
            /*for (Wechat wechat : Wechat.values()) {
                out.println(wechat.name() + " : " + wechat.getVal());
            }*/
            return;
        }
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtils.checkSignature(request)) {
            out.print(request.getEchostr());
        }
    }

    public void dealPostRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            res.setCharacterEncoding(Project.ENCODING);
            Message message = MessageUtils.xml2Bean(Message.class, req.getInputStream());
            if (null == message) {
                return;
            }
            Message wechatResponse;
            if (message.is(Message.Type.text)) {
                String msg = TuringUtils.getServiceUrl(message.getContent());
                wechatResponse = new TextMessage(message, msg);
            } else {
                wechatResponse = new TextMessage(message, TuringUtils.DEFAULT_MSG);
            }
            String xml = MessageUtils.bean2Xml(wechatResponse);
            res.getWriter().write(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
