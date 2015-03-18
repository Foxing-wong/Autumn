package us.cijian.autumn.utils;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String str){
            return null == str || str.trim().isEmpty();
    }

}
