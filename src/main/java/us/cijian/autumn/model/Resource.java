package us.cijian.autumn.model;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

    HTML5_TEMPLATE;

    private final static int BUFFER_SIZE = 2048;

    private final static ClassLoader LOADER = Resource.class.getClassLoader();

    private final static String TEMPLATE_PREFIX = "main/resources/template/";

    public final static String get(Resource res) throws IOException {
        InputStream is = getInputStream(res.template());
        StringBuilder stringBuilder = new StringBuilder();
        byte[] buffer = new byte[BUFFER_SIZE];
        // 读取内容
        int readBytes;
        while ((readBytes = is.read(buffer)) > 0) {
            stringBuilder.append(new String(buffer, 0, readBytes));
        }
        return stringBuilder.toString();
    }

    private final static InputStream getInputStream(final String resourceName) {
        return LOADER.getResourceAsStream(TEMPLATE_PREFIX + resourceName);
    }

    private String template() {
        return this.name().toLowerCase() + ".ftl";
    }


}
