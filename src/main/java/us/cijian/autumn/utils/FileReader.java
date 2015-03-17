package us.cijian.autumn.utils;

import java.io.IOException;
import java.io.InputStream;

import us.cijian.autumn.model.Resource;

public final class FileReader {
	
	private final static String TEMPLATE_DIRECTORY = "main/resources/template/";

	private final static ClassLoader LOADER = Resource.class.getClassLoader();

	private final static int BUFFER_SIZE = 2048;

	public static final String get(Resource res) throws IOException {
		StringBuilder result = new StringBuilder();
		// 读取内容
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytes;
		InputStream is = getInputStream(template(res));
		while ((bytes = is.read(buffer)) > 0) {
			result.append(new String(buffer, 0, bytes));
		}
		return result.toString();
	}

	private final static InputStream getInputStream(final String resourceName) {
		return LOADER.getResourceAsStream(TEMPLATE_DIRECTORY + resourceName);
	}

	public static String template(Resource res) {
		return res.name().toLowerCase() + "_template.ftl";
	}

}
