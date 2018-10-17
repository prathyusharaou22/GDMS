package cts.gdms.util;

import java.util.ResourceBundle;

public final class SQLUtill {

	private SQLUtill() {

	}

	public static String getSqlProperty(final String key) {

		final ResourceBundle resource = ResourceBundle.getBundle("sql");
		return resource.getString(key);

	}
	
	
}
