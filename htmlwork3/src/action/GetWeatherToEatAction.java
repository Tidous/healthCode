package action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import action.query.QueryWeatherAction;

public class GetWeatherToEatAction extends AbstractJsonLogAction {
	
	private String cityId;
	private String advice;
	
	public String execute() throws IOException {
		before();

		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
        
        QueryWeatherAction queryw = new QueryWeatherAction();
        advice = queryw.Weather(cityId);
		after();
		print();

		return SUCCESS;
	} 
	
	@Override
	public String getRetmsg() {
		return retmsg;
	}

	@Override
	public String getRetcode() {
		return retcode;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAdvice() {
		return advice;
	}
}
