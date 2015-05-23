package us.cijian.autumn.module;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.RiddleAnswer;
import us.cijian.autumn.pojo.TextMessage;
import us.cijian.autumn.utils.HttpUtils;

import java.util.List;

/**
 * Created by MurphyL on 2015/5/16.
 * 坑爹到一塌糊涂啊，不想改~~
 */
public final class RiddlePlugin extends AbstractTextPlugin {

    private String msRiddleUrl = "http://couplet.msra.cn/zimi/LightAnswerService.svc/Answer";
    private String queryParameter = "{\"question\":\"%s\",\"engineType\":0,\"topic\":0,\"focuseAnswerType\":\"字谜\"}";

    public TextMessage process(Message message) {
        TextMessage resMsg = new TextMessage(message);
        String result;
        // 解析参数，调用微软谜语服务获取结果
        String key = clean(message.getContent());
        String params = String.format(queryParameter, key);
        result = HttpUtils.postJson(msRiddleUrl, params);

        if (StringUtils.isBlank(result)) {
            return resMsg;
        }
        try {   // 拼装文本消息，预期返回正常，不正常就丢弃结果~
            String answerItems = JSON.parseObject(result).getJSONObject("d").getString("AnswerItems");
            List<RiddleAnswer> items = JSON.parseArray(answerItems, RiddleAnswer.class);
            if (null == items) {
                resMsg.setContent("你太厉害了，我实在不会！");
                return resMsg;
            }
            resMsg.setContent(serializeAnswer(items));
        } catch (Exception e) {

        }
        return resMsg;
    }

    /**
     * 解析参数：预期的参数结构有：
     * 1. my [谜面];
     * 2. miyu [谜面];
     * 3. 谜语 [谜面]。
     * 按照理想既定规则，每个关键语字和谜面之前都有空格（反正自己玩，就理想点了）
     *
     * @param text
     * @return
     */
    private String clean(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        String[] pairs = text.trim().split(" ");
        String riddle = pairs[1];
        if (pairs.length < 2 || StringUtils.isBlank(riddle)) {
            return null;
        }
        return riddle.trim();
    }

    /**
     * toString 代码，完全是为了适应个人洁癖
     *
     * @param answers
     * @return
     */
    private String serializeAnswer(List<RiddleAnswer> answers) {
        StringBuffer answerString = new StringBuffer();
        for (int i = 0; i < answers.size(); i++) {
            if (answerString.length() > 0) {
                answerString.append("；\n");
            }
            answerString.append((i + 1) + ". ");
            RiddleAnswer answer = answers.get(i);
            answerString.append(answer.toString());
        }
        answerString.append("。");
        return answerString.toString();
    }

}
