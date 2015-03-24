package us.cijian.autumn.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class CacheUtils {

    private Map<Class, Object> cache = new HashMap<Class, Object>();

    private CacheUtils() {
    }

    public static <T> boolean cache(T val) {
        return cache(val.getClass(), val);
    }

    public static <T> boolean cache(Class key, T val) {
        if (null == val || null == key || Inner.ourInstance.cache.containsKey(key)) {
            return false;
        }
        Inner.ourInstance.cache.put(key, val);
        return true;
    }

    public static <T> T get(Class<T> tClass){
        return tClass.cast(Inner.ourInstance.cache.get(tClass));
    }

    private static class Inner {
        static CacheUtils ourInstance = new CacheUtils();
    }

}
