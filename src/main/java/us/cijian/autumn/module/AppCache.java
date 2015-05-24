package us.cijian.autumn.module;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MurphyL on 5/24/2015.
 */
public final class AppCache {

    private Map<String, Object> cache;

    private AppCache(Map<String, Object> cache) {
        this.cache = cache;
    }

    public static boolean cache(String key, Object val) {
        Map<String, Object> innerCache = Inner.instalce.cache;
        if (StringUtils.isBlank(key) && null == val || innerCache.containsKey(key)) {
            return false;
        }
        innerCache.put(key, val);
        return true;
    }

    public static <T> T get(String key) {
        return (T) Inner.instalce.cache.get(key);
    }

    private static class Inner {
        protected static AppCache instalce = new AppCache(new HashMap<String, Object>());
    }

}
