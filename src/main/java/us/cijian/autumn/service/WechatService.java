package us.cijian.autumn.service;

import com.alibaba.fastjson.JSON;
import us.cijian.autumn.constants.Plugin;
import us.cijian.autumn.constants.Wechat;
import us.cijian.autumn.module.AbstractTextPlugin;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.utils.MessageUtils;
import us.cijian.autumn.module.TuringPlugin;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MurphyL on 2015/5/22.
 */
public class WechatService {

    public void getAllSettings() {
        System.out.println(JSON.toJSONString(Wechat.values()));
    }

    /**
     * 若是文本消息——则匹配插件，若无对应的插件，则走 Turning 机器人
     *
     * @param req
     * @return
     */
    public Message processWechatRequest(HttpServletRequest req) {
        Message message = null;
        try {   // 解析微信端的消息
            message = MessageUtils.xml2Bean(Message.class, req.getInputStream());
        } catch (Exception e) {
            return new TextMessage(message, TuringPlugin.DEFAULT_MSG);
        }
        if (message.is(Message.Type.text)) {
            String content = message.getContent();
            AbstractTextPlugin plugin = Plugin.getMatchPlugin(content);
            return plugin.process(message);
        }
        return new TextMessage(message, TuringPlugin.DEFAULT_MSG);
    }

}
