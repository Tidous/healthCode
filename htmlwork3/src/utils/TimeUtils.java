/**
 * 
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenxk
 *
 */
public class TimeUtils {
	

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 
	private static SimpleDateFormat tinyFormatter = new SimpleDateFormat("HHmmssSSS"); 
	

	
	

	public static String getTransDate() {
		return formatter.format(new Date());
	}

	
	public static String getTransTime() {
		return tinyFormatter.format(new Date());
	}



}
