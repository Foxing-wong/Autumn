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

    Plugin(Class plugin, String... keywords) {
        for (int i = 0; i < keywords.length; i++) {
            keywords[i] += " ";
        }
        this.keys = keywords;
        this.plugin = plugin;
    }

    private boolean is(String text) {
        for (String search : keys) {
            if (StringUtils.startsWith(text, search)) {
                return true;
            }
        }
        return false;
    }

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
