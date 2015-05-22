package us.cijian.autumn.servlet;

import us.cijian.autumn.config.Plugin;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.plugins.AbstractPlugin;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.utils.MessageUtils;
import us.cijian.autumn.utils.TuringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by luohao4 on 2015/3/19.
 */
public class WechatServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            dealPostRequest(req, res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 文本消息首先加载插件，如果加载不到则递交到机器人
     *
     * @param req
     * @param res
     * @throws IOException
     */
    public void dealPostRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            res.setCharacterEncoding(Project.ENCODING);
            Message message = MessageUtils.xml2Bean(Message.class, req.getInputStream());
            if (null == message) {
                return;
            }
            Message wechatResponse;
            if (message.is(Message.Type.text)) {
                String content = message.getContent();
                AbstractPlugin plugin = Plugin.getMatchPlugin(content);
                if (null != plugin) {
                    wechatResponse = plugin.call(message);
                } else {
                    String msg = TuringUtils.getServiceUrl(content);
                    wechatResponse = new TextMessage(message, msg);
                }
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
