package us.cijian.autumn.plugins;

import com.alibaba.fastjson.JSON;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.pojo.TuringResponse;
import us.cijian.autumn.utils.HttpUtils;

/**
 * Created by MurphyL on 2015/5/16.
 */
public class TuringPlugin extends AbstractTextPlugin {

    public static final String DEFAULT_MSG = "我以前和你一样也是个冒险家，直到我的膝盖中了一箭。";
    private static final String SERVICE_URL = "http://iebot.sinaapp.com?in=";
    // "http://www.tuling123.com/openapi/api?key=a5c67c0a59934a2255567f24a1ce6bf2&info=";

    @Override
    public TextMessage process(Message message) {
        try {
           String text = HttpUtils.getJson(SERVICE_URL + message.getContent());
            TuringResponse response = JSON.parseObject(text, TuringResponse.class);
            if (response.isCorrect()) {
                return new TextMessage(message, response.getText());
            }
        } catch (Exception e) {

        }
        return new TextMessage(message, DEFAULT_MSG);
    }

}
