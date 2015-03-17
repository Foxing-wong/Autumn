package us.cijian.autumn.utils;

import us.cijian.autumn.config.Resource;

import java.io.*;

public final class FileReader {

    private final static String TEMPLATE_DIRECTORY = "main/resources/template/";

    private final static ClassLoader LOADER = Resource.class.getClassLoader();

    private final static int BUFFER_SIZE = 2048;

    public static final String get(Resource res) throws IOException {
        return get(res.name());
    }

    public static final String get(String res) throws IOException {
        StringBuilder result = new StringBuilder();
        // 读取内容
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytes;
        InputStream is = getInputStream(name(res));
        while ((bytes = is.read(buffer)) > 0) {
            result.append(new String(buffer, 0, bytes));
        }
        return result.toString();
    }

    private final static InputStream getInputStream(final String resourceName) {
        InputStream is = LOADER.getResourceAsStream(TEMPLATE_DIRECTORY + resourceName);
        try {
            Reader reader = new InputStreamReader(is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String name(String name) {
        return name.toLowerCase() + ".ftl";
    }

    public static String name(Resource res) {
        return res.name().toLowerCase() + ".ftl";
    }

}