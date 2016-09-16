package action.query;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import net.sf.json.JSONObject;

import action.AbstractJsonLogAction;

public class QueryClientAction extends AbstractJsonLogAction {
	
	private StringBuilder sb; 

    BufferedReader br;// 读取data数据流 
    
    private JSONObject jsonData; 
    private JSONObject info;
    
    private String country;
    private String area;
    private String region;
    private String city;
	
	public void ClientInfo(String ip) throws IOException ,NullPointerException {

		URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+ip);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setConnectTimeout(1000);
        urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConn.setRequestProperty("Accept-Charset", "utf-8");
        urlConn.connect();

        try { 
            br = new BufferedReader(new InputStreamReader( 
            		urlConn.getInputStream(), "utf-8")); 

            sb = new StringBuilder(); 
            String line = null; 
            while ((line = br.readLine()) != null) 
                sb.append(line); 

        } catch (SocketTimeoutException e) { 
            System.out.println("连接超时"); 
        } catch (FileNotFoundException e) { 
            System.out.println("加载文件出错"); 
        } 

        String datas = sb.toString();
        jsonData = JSONObject.fromObject(datas); 
        //System.out.println(jsonData.toString());  
        info = jsonData.getJSONObject("data");
        country = (String) info.get("country");
        area = (String) info.get("area");
        region = (String) info.get("region");
        city = (String) info.get("city");
        
        after();
        print();

        logOther(country);
        logOther(area);
        logOther(region);
        logOther(city);        
		
	}
	
	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }

	public String getCountry() {
		return country;
	}

	public String getArea() {
		return area;
	}

	public String getRegion() {
		return region;
	}

	public String getCity() {
		return city;
	}
}
