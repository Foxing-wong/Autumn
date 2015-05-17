package us.cijian.autumn.plugins;

import us.cijian.autumn.pojo.Message;

/**
 * Created by MurphyL on 2015/5/17.
 * 不知道有什么用，既然写了，就当作规范留着吧
 */
public interface AbstractPlugin {
    
    <T extends Message> T call(T message);

}
