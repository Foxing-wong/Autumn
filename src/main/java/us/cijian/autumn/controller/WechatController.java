package us.cijian.autumn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import us.cijian.autumn.constants.Project;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.WechatRequest;
import us.cijian.autumn.service.WechatService;
import us.cijian.autumn.utils.MessageUtils;
import us.cijian.autumn.utils.SignUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MurphyL on 2015/5/23.
 * 根路径需要配置到微信开发者中心， GET 请求用来验证准确性
 * POST 用来响应用户的请求，微信在接收到用户请求后，会将用户信息以及请求内容 POST 到当前地址
 */
public class WechatController extends HttpServlet {

    private WechatService wechatService;

    /**
     * 加载 Spring Bean（需要 XML 配置）
     * @throws ServletException
     */
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        wechatService = context.getBean(WechatService.class);
        System.out.println("初始化微信公众号消息处理器完成~");
    }

    /**
     * 处理用户的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = wechatService.processWechatRequest(req);
        resp.setCharacterEncoding(Project.ENCODING);
        resp.getWriter().write(MessageUtils.bean2Xml(message));
    }

    /**
     * 验证微信断的配置信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WechatRequest wechatRequest = new WechatRequest(req);
        String text = wechatRequest.getTimestamp();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtils.checkSignature(wechatRequest)) {
            text = wechatRequest.getEchostr();
        }
        resp.getWriter().write(text);
    }


}
