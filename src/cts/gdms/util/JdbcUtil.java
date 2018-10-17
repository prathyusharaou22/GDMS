package cts.gdms.util;

import java.util.ResourceBundle;



public final class JdbcUtil {
	
	private JdbcUtil(){
		
	}
	
	public static String getProperty(final String key){
		String value;
		final ResourceBundle rBundle=ResourceBundle.getBundle("jdbc");
		value=rBundle.getString(key);
		return value;
	}	
	
}

