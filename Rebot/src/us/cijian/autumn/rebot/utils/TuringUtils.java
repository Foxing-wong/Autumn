package us.cijian.autumn.rebot.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by MurphyL on 6/7/2015.
 */
public final class TuringUtils {

    private static final String SERVICE_URL = "http://www.tuling123.com/openapi/api?key=a5c67c0a59934a2255567f24a1ce6bf2&info=";

    public final static String process(String text) throws Exception {
        URL getUrl = new URL(SERVICE_URL + text);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        Scanner scanner = new Scanner(connection.getInputStream(), "utf-8");
        return scanner.useDelimiter("\\A").next();
    }
}
