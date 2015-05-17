package us.cijian.autumn.utils;

import com.alibaba.fastjson.JSON;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.pojo.TuringResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MurphyL on 2015/5/16.
 */
public class TuringUtils {


    public static final String DEFAULT_MSG = "我以前和你一样也是个冒险家，直到我的膝盖中了一箭。";
    private static final String SERVICE_URL = "http://www.tuling123.com/openapi/api?key=a5c67c0a59934a2255567f24a1ce6bf2&info=";

    public static String getServiceUrl(String info) throws IOException {
        URL getUrl = new URL(SERVICE_URL + info);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Project.ENCODING));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        TuringResponse response = JSON.parseObject(sb.toString(), TuringResponse.class);
        if(response.isCorrect()){
            return response.getText();
        }
        return DEFAULT_MSG;
    }


    public static void main(String[] args) {
        try {
            getServiceUrl("asd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
