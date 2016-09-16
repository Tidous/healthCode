package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormat {
		
		public static String format(Date date){
			
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return myFmt.format(date);
			
		}
		
		
}
