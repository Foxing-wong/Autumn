package us.cijian.autumn.plugins;

import us.cijian.autumn.pojo.Message;

/**
 * Created by MurphyL on 2015/5/17.
 */
public abstract class AbstractPlugin {

    /**
     * 每个插件的唯一指定入口方法
     * @param message
     * @param <T>
     * @return
     */
    public abstract <T extends Message> T call(T message);

}
