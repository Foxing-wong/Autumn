package us.cijian.autumn.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import us.cijian.autumn.config.Project;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by MurphyL on 2015/5/16.
 */
public final class HttpUtils {

    /*public static final String  get(String url){

    }*/
    public static final String post(String url, String params, ContentType type) throws UnsupportedEncodingException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        StringEntity entity;
        if (null == type) {
            entity = new StringEntity(params, ContentType.APPLICATION_FORM_URLENCODED);
        } else {
            entity = new StringEntity(params, type);
        }
        post.setEntity(entity);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            CloseableHttpResponse response = client.execute(post);
            response.getEntity().writeTo(outputStream);
            response.close();
        } catch (IOException e) {

        }
        return outputStream.toString(Project.ENCODING);
    }

    public static final String postJson(String url, String params) throws UnsupportedEncodingException {
        return post(url, params, ContentType.APPLICATION_JSON);
    }



    /*public static final String post(String url){
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
    }*/

    public static void main(String[] args) {
        try {
            String res = postJson("http://couplet.msra.cn/zimi/LightAnswerService.svc/Answer", "{\"question\":\"人间垂半帘\",\"engineType\":0,\"topic\":0,\"focuseAnswerType\":\"字谜\"}");
            System.out.println(res);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
