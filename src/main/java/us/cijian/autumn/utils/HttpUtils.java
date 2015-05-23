package us.cijian.autumn.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import us.cijian.autumn.constants.Project;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by MurphyL on 2015/5/16.
 */
public final class HttpUtils {

    private HttpUtils() {
    }

    public static final String get(String url, String contentType) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        if (StringUtils.isNotBlank(contentType)) {
            get.setHeader(new BasicHeader(HTTP.CONTENT_TYPE, contentType));
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            CloseableHttpResponse response = client.execute(get);
            response.getEntity().writeTo(outputStream);
            response.close();
        } catch (IOException e) {
            return "Sorry， 网络出现错误！";
        }
        try {
            return outputStream.toString(Project.ENCODING);
        } catch (Exception e) {
            return "Sorry， 系统出现错误！";
        }
    }

    public static final String post(String url, String params, ContentType type) {
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
            return "Sorry， 网络出现错误！";
        }
        try {
            return outputStream.toString(Project.ENCODING);
        } catch (Exception e) {
            return "Sorry， 系统出现错误！";
        }
    }

    public static final String postJson(String url, String params) {
        return post(url, params, ContentType.APPLICATION_JSON);
    }

    public static final String getJson(String url) {
        return get(url, ContentType.APPLICATION_JSON.toString());
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
}
