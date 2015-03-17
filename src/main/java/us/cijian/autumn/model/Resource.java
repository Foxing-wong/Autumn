package us.cijian.autumn.model;

import java.io.IOException;

import us.cijian.autumn.utils.FileReader;

/**
 * Created by Murphy on 2/15/2015.
 */
public enum Resource {

	HTML5;
	
	public final String get() {
		try {
			return FileReader.get(this);
		} catch (IOException e) {
			return null;
		}
	}


}
