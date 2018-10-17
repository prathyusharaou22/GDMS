package cts.gdms.util;

import java.util.ResourceBundle;

public final class MessageUtil {

	private MessageUtil() {

	}

	public static String getProperty(final String key) {
		final ResourceBundle resource = ResourceBundle.getBundle("Message");
		return resource.getString(key);

	}

}
