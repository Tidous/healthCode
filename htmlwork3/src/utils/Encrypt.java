package utils; 

import org.apache.commons.lang3.StringUtils;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
/** 
 * @description: 
 * @author: yangyt
 * @date: 2014-12-2 上午9:40:12
 */
public class Encrypt {

	/** @description  
	 * @param args          
	 * @author yangyt
	 * @date   2014-12-2 上午9:40:12 
	 */

	public static void main(String[] args){
		String password="111111";              
//		MessageDigest md5 = null;
//		try {
//			md5 = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}           
//		BASE64Encoder base64en = new BASE64Encoder();           
//		try {
//			password=base64en.encode(md5.digest(password.getBytes("utf-8")));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		System.out.println("加密前="+password); 
		password = encrypStrA(password);
		System.out.println("加密后="+password);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		System.out.println( sdf.format(System.currentTimeMillis()));
//		
//		System.out.println(new Date());
//		
//		 SimpleDateFormat myFmt1=new SimpleDateFormat("HHmmss"); 
//		 System.out.println(myFmt1.format(new Date()));
		 
//		Calendar calendar = new GregorianCalendar();   
//		Date d = new Date();   
//		calendar.setTime(d); 
//		Calendar calendar1 = Calendar.getInstance();   
//		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));   
//		System.out.println("DAY_OF_WEEK1: " + calendar1.get(Calendar.DAY_OF_WEEK));
		
//		SimpleDateFormat sdf_8 = new SimpleDateFormat("yyyyMMdd");
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)-1);
//		cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)+12);
//		String strDate = "";
//		
//		Calendar curr = Calendar.getInstance();
//		curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+1);
//		Date date=curr.getTime();
//		try {
//			strDate = sdf_8.format(cal.getTime());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		List lsid = new ArrayList();
//		lsid = null;
//		System.out.println("一年后的时间为："+lsid.size());
//		
//		 String filepath = "file:/192.168.1.222/doc/C179/142370427864726.xml";
//		String filepath = "file:\\192.168.1.222\\doc\\C179\\142370427864726.xml";
//		 String filename = "142370427864726.xml";
//		 String dfilename = "C17900上海信托红宝石安心稳健系列投资资金信托基金(上信-H-7001）项目定期管理报告2015-02-15";
//
//		    if (filename.endsWith(".xml"))
//		      dfilename = dfilename + ".doc";
//		    else
//		      dfilename = filename;
//		    
//		    URL url;
//			try {
//				url = new URL(filepath);
//				URLConnection uc = url.openConnection();
//			    uc.connect();
//			    InputStream is = uc.getInputStream();
//			    ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//			    int bytesRead = 0;
//			    byte[] buffer = new byte[8192];
//			    while ((bytesRead = is.read(buffer)) != -1) {
//			      os.write(buffer, 0, bytesRead);
//			    }
//			    is.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		System.out.println(chenxkencrypt("101145"));
		System.out.println(chenxkdecrypt("100015shanghai32shanghai829"));
		System.out.println(chenxkdecrypt("100478shanghai99shanghai937"));
		System.out.println(chenxkencryptcheck("100478shanghai99shanghai937"));



		
		
	}
	
	
	
private static final String FillStr = "[1E<$&@&>n2]";
	
	private static final int[][] ExChange = {
			{ 23, 25, 29, 0, 0, 36, 28, 37, 0, 35, 39, 0, 32, 31, 0, 0, 26, 27, 34 },
			{ 27, 33, 30, 0, 0, 21, 24, 29, 0, 38, 22, 0, 39, 0, 32, 36, 0, 37, 0 } };

	private static final String[] PlusStr = { 
			"200022012120110102201101211011112102112",
			"021102010210101210220001112010211020100",
			"120002101012010220221101202011021211010",
			"210201012210202011111212011020112011020",
			"202112211012101100222120121201012121021",
			"102121210021020221211010112020110202011",
			"022102110121212201211221002201100012100",
			"221120101220211202012101210210110010221",
			"012020201101021022112112112111102101101",
			"101212012211021101011221021022022100110",
			"012202110210011202101220121100101211002",
			"220102021101202012101102010201202011012",
			"121111212010121021120101111021021202112" };
	
	/* DES加密 */
	private static final String DESKey = "[9U<$*@&>n8]";
	
    private static final String KEY_ALGORITHM = "DES";   
    
    private static final String DEFAULT_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	
	/** OpenFund主程序原来20位的加密算法 */
	public static String encrypStr(String sPwd) {
		String pwdmask = "~!@#$%^&*()-_=+[]{}\\|`;:\",./?><";
		String sEnter = "\n";
		java.lang.String result = null;
		if (sPwd == null || sPwd.equals(""))
			return "";
		byte pwd[] = sPwd.getBytes();
		byte mask[] = pwdmask.getBytes();
		byte enter[] = sEnter.getBytes();
		int n = mask.length;
		int size = pwd.length;
		if (n > size)
			n = size;
		for (int i = 0; i < n; i++) {
			pwd[i] ^= mask[i];
			if (pwd[i] == 13)
				pwd[i] = enter[0];
		}

		result = new java.lang.String(pwd);
		result = result.replaceAll("&", "&&");
		result = result.replaceAll("\"", "&d");
		result = result.replaceAll("'", "&s");
		return result;
	}

	/** OpenFund主程序新的40位加密算法 */
	public static String encrypStrA(String sPwd) {

		String Str = "";
		int SumAscii = 0;
		int PwdLen = sPwd.length();
		if(PwdLen > 12){
			return sPwd;
		}
		Str = Integer.toHexString(PwdLen).toUpperCase() + sPwd; // 密码位数+密码
		String Str13 = (String) (Str + FillStr).substring(0, 13); // 补足13位长度
		//int Len1 = Str13.length();
		byte[] Byte13 = Str13.getBytes();
		for (int i = 0; i < Byte13.length; i++) {
			SumAscii = SumAscii + Byte13[i];
		}

		int PlusNum = SumAscii % 13;
		int ChgNum = SumAscii % 2;

		char First = (char) (ChgNum * 13 + PlusNum + 'A');

		int n;
		String Str39 = "";
		for (int j = 0; j < Byte13.length; j++) {
			n = (255 * 255 - Byte13[j] * Byte13[j]);
			Str39 = Str39 + (String) (c10to34(n)).substring(1); // 转换成34进制，共4位，最高位肯定是1,保留3位即可
		}

		byte[] byte39 = Str39.getBytes();
		String sTmp = "";
		char sTmp1;
		for (int k = 0; k < byte39.length; k++) {
			char[] byteTmp = (PlusStr[PlusNum]).toCharArray();
			sTmp1 = (char) (byte39[k] + (byteTmp[k] - '0'));
			sTmp = sTmp + sTmp1;
		}
		Str39 = sTmp;
		byte39 = Str39.getBytes();
		for (int l = 0; l < 19; l++) {
			if (ExChange[ChgNum][l] > 0) {
				byte bTmp = byte39[l];
				byte39[l] = byte39[ExChange[ChgNum][l] - 1];
				byte39[ExChange[ChgNum][l] - 1] = bTmp;
			}
		}

		return First + new String(byte39);
	}
	
	
	/**
	 * 函数名称:c34to10
	 * 函数功能:34进制向十进制的转换。
	 * @return
	 */
	public static int c34to10(String str) {
		int n34[] = new int[4];
		int i,j;
		int n = 0;
		char ch;

		if (str.length()!=4) {
			return n;
		}
		n34[0] = 1;
		for (i = 2; i<=4; i++) {
			n34[i-1] = n34[i-2]*34;
		}

		for (i=1; i<=4; i++) {
			ch = str.toCharArray()[i-1];
			j = ch-'0';
			if ((ch>='0')&&(ch<='9')) {
				j=ch-'0';
			}else{
				j=ch-'A'+10;
			}
			n=n+j*n34[5-i-1];
		}
		return n;
	}

	/** 十进制向34进制的转换。 */
	public static String c10to34(int n) {
		int nIdx;
		int[] n34 = new int[35];
		char[] Char34 = new char[35];
		char sTmp;
		n34[0] = 1;
		for (nIdx = 1; nIdx < 4; nIdx++)
			n34[nIdx] = n34[nIdx - 1] * 34;
		for (nIdx = 0; nIdx < 10; nIdx++)
			Char34[nIdx] = (char) ('0' + nIdx);
		for (nIdx = 10; nIdx < 34; nIdx++)
			Char34[nIdx] = (char) ('A' + nIdx - 10);

		String sRst = "";
		for (nIdx = 3; nIdx >= 0; nIdx--) {
			sTmp = Char34[n / n34[nIdx]];
			sRst = sRst + sTmp;
			n %= n34[nIdx];
		}
		return sRst;
	}

	/**  
	 * DES加密  
	 * @param pwd  待加密数据  
     * @throws Exception
	 * @author yaohui 
	 * @date 2013-04-22
     */  
    public static String hsDesEncrypt(String pwd) throws Exception{
    	byte[] data = pwd.getBytes();
    	Key key = getKey();
    	Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
    	// 使用密钥初始化，设置为加密模式  
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	byte[] dataByte = cipher.doFinal(data);
    	int len = dataByte.length;
    	byte[] dataByteTmp = new byte[len*2];
    	for (int i=0; i<len;i++){
    		dataByteTmp[i*2] = (byte) (dataByte[i]/len +( (dataByte[i]/len>=10)?'A'-10:'0' ));
    		dataByteTmp[i*2+1] = (byte) (dataByte[i]%len +( (dataByte[i]%len>=10)?'A'-10:'0' ));
    	}
    	return byteArr2HexStr(dataByteTmp);
    }
    
    /**  
     * 解密
     * @param data  待解密数据  
     * @throws Exception  
	 * @author yaohui 
	 * @date 2013-04-22
     */  
	public static String hsDesDecrypt(String pwd) throws Exception{
		byte[] data = hexStr2ByteArr(pwd);
    	Key key = getKey();
		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		// 数据还原
		int len = data.length;
		byte[] tmp1 = new byte[len/2];
		for (int i=0; i < len; i+=2) {
		    tmp1[i/2] = (byte) ((data[i] - ((data[i] >= 'A')?('A'-10) : '0')) * len/2 + (data[i+1] - ((data[i+1] >= 'A')?('A'-10) : '0')));
		}
		
		return new String(cipher.doFinal(tmp1));   
	}  
	
	/**  
	 * 转换密钥  
	 * @param key 二进制密钥  
	 * @return Key 密钥  
	 * @author yaohui 
	 * @date 2013-04-22
	 * @throws Exception  
	 */  
	private static Key getKey() throws Exception{
    	//实例化DES密钥规则 
    	DESKeySpec dks = new DESKeySpec(DESKey.getBytes());
    	//实例化密钥工厂 
    	SecretKeyFactory skf = SecretKeyFactory.getInstance(KEY_ALGORITHM);
    	//生成密钥  
    	SecretKey  secretKey = skf.generateSecret(dks);
    	return secretKey;
	}
	    
	/**  
	 * 将表示16进制值的字符串转换为byte数组
	 * @param strIn 需要转换的字符串  
	 * @return 转换后的byte数组  
	 * @author yaohui 
	 * @date 2013-04-22
	 * @throws Exception  
	 */  
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
		    String strTmp = new String(arrB, i, 2);
		    arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}
	
	/**  
	 * 将byte数组转换为表示16进制值的字符串
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程  
	 * @param arrB 需要转换的byte数组  
	 * @return 转换后的字符串  
	 * @author yaohui 
	 * @date 2013-04-22
	 * @throws Exception  
	 */  
	public static String byteArr2HexStr(byte[] arrB) throws Exception {   
		int iLen = arrB.length;   
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数 
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 
	 * @param customerId
	 * @return accountInfo
	 */
	public static String chenxkencrypt(String customerId){
		
		int randomNum  =((int)(Math.random()*100))+1;
		
		int x=10000,z=0;
		
		if(customerId!=null){
			
			x = Integer.parseInt(customerId);
			
		}
		
		z = ((x*x)+(randomNum*13+5))%1573;
		
		return String.valueOf(x)+"shanghai"+String.valueOf(randomNum)+"shanghai"+String.valueOf(z);
		
		
	}
	
	/**
	 * to check if the accouninfo is validate
	 * @param token
	 * @return true if validate or false
	 */
	public static Boolean chenxkencryptcheck(String token){
		if(StringUtils.isBlank(token)){
			return false;
		}
		
		String[] arr = token.split("shanghai");
		
		if(arr.length>2){
			
			int x = Integer.parseInt(arr[0]);
			
			int y = Integer.parseInt(arr[1]);
			
			int z = ((x*x)+(y*13+5))%1573;
			
			if(z==Integer.parseInt(arr[2])){
				
				return true;
				
			}
			
		}
		return false;
		
	}
	/**
	 * if token is invalid,return null
	 * @param token
	 * @return customerId
	 */
	public static String chenxkdecrypt(String token){
//		System.out.println("解析token："+token);
		if(!chenxkencryptcheck(token)){
			return null;
		}
		
		String[] arr = token.split("shanghai");
		
		if(arr.length>2){
			
			return arr[0];
			
		}
		
		return null;
	}
	
	

}
 
