package us.cijian.autumn.servlet;

import us.cijian.autumn.config.Wechat;
import us.cijian.autumn.mapper.SettingsMapper;
import us.cijian.autumn.pojo.Setting;
import us.cijian.autumn.utils.SignUtils;
import us.cijian.autumn.utils.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by luohao4 on 2015/3/19.
 */
public class WechatServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        dealRequest(req, res);
    }

    private void dealRequest(HttpServletRequest req, HttpServletResponse res) throws IOException{
        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");

        PrintWriter out = res.getWriter();
        
        if(StringUtils.isBlank(signature)){
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

}
