/**
 * 
 */
package utils;

import java.util.Random;

/**
 * @author chenxk
 *
 */
public class RandomUtil {

	public static String getRandomNumberString(int length) { //length表示生成字符串的长度
	    String base = "0123456789";   
	    //abcdefghijklmnopqrstuvwxyz
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }
		System.out.println(sb.toString());
	    return sb.toString();   
	 }  
}
