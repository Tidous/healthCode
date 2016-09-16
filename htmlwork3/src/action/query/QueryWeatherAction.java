package action.query;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import action.AbstractJsonLogAction;

public class QueryWeatherAction extends AbstractJsonLogAction {
	
	private String Ctiyid;
	private String adv;
      
    public String Weather(String Cityid) throws IOException ,NullPointerException{ 
  
        this.Ctiyid = Cityid;
        this.adv = null;
        
        Document doc = Jsoup.connect("http://wthrcdn.etouch.cn/WeatherApi?citykey="+Ctiyid).get();
        
        String html = doc.html();
        
        String a[] = html.split("yesterday");
        
        String b[] = a[1].split("<high_1>\n");
        
        String c[] = b[1].split("高温");
        
        String yesterdayHighest = c[1].split("℃")[0].trim();
        
        String d[] = html.split("<shidu>\n");
        
        String shidu = d[1].split("%")[0].trim();
        
        String e[] = html.split("<high>\n");
        
        String f[] = e[1].split("高温");
        
        String todayHighest = f[1].split("℃")[0].trim();
        
        int T1 = Integer.parseInt(yesterdayHighest);
        int T2 = Integer.parseInt(todayHighest);
        int SD = Integer.parseInt(shidu);
        
        if ((T1 - T2)>3 && SD > 65) {
        	adv = "今天最高温度："+T2+"°C 湿度："+SD+"% 专家建议为：少食：酸寒、甘寒、苦寒。多吃多用：辛热、甘热。";
        }
        else if ((T1 - T2)>0 && SD < 65) {
        	adv = "今天最高温度："+T2+"°C 湿度："+SD+"% 专家建议为：少食：酸寒、甘冷、苦寒。多吃多用：辛热、苦热。";
        }
        else if ((T1 - T2)<0 && SD > 65) {
        	adv = "今天最高温度："+T2+"°C 湿度："+SD+"% 专家建议为：少食：糖。如果很冷，可在上午或中午使用辛热。多吃多用：苦热、淡味、甘热。";
        }
        else if ((T1 - T2)<0 && SD < 65) {
        	adv = "今天最高温度："+T2+"°C 湿度："+SD+"% 专家建议为：少食：盐、辛热。多吃多用：苦、甘、酸。";
        }
        else {
        	adv = "今天最高温度："+T2+"°C 湿度："+SD+"% 专家建议为：无应对食疗。如有不适，请参看“看人吃饭”。";
        }
        
        return adv;
    }

	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }
}
