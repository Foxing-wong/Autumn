package us.cijian.autumn.module;

import us.cijian.autumn.pojo.Message;
import us.cijian.autumn.pojo.TextMessage;

/**
 * 文本消息插件
 * Created by MurphyL on 2015/5/17.
 */
public abstract class AbstractTextPlugin {

    /**
     * 每个插件的唯一指定入口方法
     * @param message
     * @return
     */
    public abstract TextMessage process(Message message);

}
