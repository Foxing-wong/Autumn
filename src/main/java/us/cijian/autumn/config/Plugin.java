package us.cijian.autumn.config;

import org.apache.commons.lang3.StringUtils;
import us.cijian.autumn.plugins.AbstractPlugin;
import us.cijian.autumn.plugins.RiddlePlugin;

/**
 * Created by MurphyL on 2015/5/17.
 */
public enum Plugin {

    Riddle(RiddlePlugin.class, "my", "miyu", "谜语");

    private String[] keys;
    private Class plugin;

    /**
     * 构造方法中给关键词追加空格，目的是更好的匹配每一条传入的语句
     * @param plugin
     * @param keywords
     */
    Plugin(Class plugin, String... keywords) {
        for (int i = 0; i < keywords.length; i++) {
            keywords[i] += " ";
        }
        this.keys = keywords;
        this.plugin = plugin;
    }

    /**
     * 匹配处理器类型
     * @param text
     * @return
     */
    private boolean is(String text) {
        for (String search : keys) {
            if (StringUtils.startsWith(text, search)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据理想的命名规则 （key [text]）来匹配对应的插件，并返回指定的处理器；
     * @param text
     * @return
     */
    public static final AbstractPlugin getMatchPlugin(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        text = text.trim();
        for (Plugin items : values()) {
            if (!items.is(text)) {
                continue;
            }
            try {
                return (AbstractPlugin) items.plugin.newInstance();
            } catch (Exception e) {
            }
        }
        return null;
    }
}
