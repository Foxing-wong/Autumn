package us.cijian.autumn;

import java.io.IOException;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

	HTML5;
	
	protected final static String TEMPLATE_DIRECTORY = "main/resources/template/";

	public final String get() {
		try {
			return FileReader.get(this);
		} catch (IOException e) {
			return null;
		}
	}


}
