package us.cijian.autumn.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by MurphyL on 2015/5/17.
 */
public final class TextUtils {

    private TextUtils() {
    }

    public static final boolean startWithAnyIgnoreCase(String text, String... searchs){
        if(StringUtils.isBlank(text) || ArrayUtils.isEmpty(searchs)){
            return false;
        }
        text = text.trim();
        for (String search : searchs) {
            if(StringUtils.isBlank(search)){
                continue;
            }
            if(StringUtils.startsWith(text, search.trim())){
                return true;
            }
        }
        return false;
    }

}
