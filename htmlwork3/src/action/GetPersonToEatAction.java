package action;

import hib.ora.entity.Birthdate;
import hib.ora.entity.Casetable;
import hib.service.BirthdateService;
import hib.service.CasetableService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.mail.MailSendObserver;

public class GetPersonToEatAction extends AbstractJsonLogAction {
	
	private String birthday;
	private String time;
	private String descriptionFront;
	private String dietFront;
	private String descriptionBehind;
	private String dietBehind;
	private Casetable resultFront;
	private Casetable resultBehind;
	private Birthdate birdateInfo;
	private Birthdate sysdateInfo;
	
	private String sysday;
	private String systime;
	
	@Autowired
	private BirthdateService birthdateService;
	
	@Autowired
	private CasetableService casetableService;
	
	public String execute() throws IOException {
		handleNullField();
		before();

		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		
		MailSendObserver obj = new MailSendObserver();
		
		birdateInfo = birthdateService.getUserBirthInfo(birthday, time);
		
		sysdateInfo = birthdateService.getSysdateInfo(sysday, systime);
		
		queryFront(birthday);
		
		queryBehind(birthday);
        
		after();
		print();

		return SUCCESS;
	}
	
	private void handleNullField() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c = Calendar.getInstance();
		
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND);

		Date now = new Date();
		String sysDate = dateFormat.format(now); 
		
		if (null == birthday || birthday.isEmpty()) {
			birthday = sysDate;
		}
		if (null == time || time.isEmpty()) {
			time = "";
		}
		else {
			time = time + ":00";
		}
		
		sysday = sysDate;
		systime = hour+":"+minute+":"+second;

	}
	
    public String queryBehind(String date) {
        
        if (casetableService != null) {   
        	resultBehind = casetableService.dealwithBehind(date, "N", birdateInfo, sysdateInfo);
        	if (resultBehind == null) {
        		descriptionBehind = "抱歉，没有查到您的后天信息";
            	dietBehind = "抱歉，没有查到您的后天食疗建议";
        	}
        	else {
        		descriptionBehind = resultBehind.getDescription();
            	dietBehind = resultBehind.getDiet();
        	}
        }
      
        return SUCCESS;

    }
	
	public String queryFront(String date) {
        
        if (casetableService != null) {
        	resultFront = casetableService.dealwithFront(date, "N", birdateInfo);
        	if (resultFront == null) {
        		descriptionFront = "抱歉，没有查到您的先天信息";
        		dietFront = "抱歉，没有查到您的先天食疗建议";
        	}
        	else {     		
        		descriptionFront = resultFront.getDescription();
            	dietFront = resultFront.getDiet();
        	}
        }

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Casetable getResultFront() {
		return resultFront;
	}

	public Casetable getResultBehind() {
		return resultBehind;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescriptionFront() {
		return descriptionFront;
	}

	public String getDietFront() {
		return dietFront;
	}

	public String getDescriptionBehind() {
		return descriptionBehind;
	}

	public String getDietBehind() {
		return dietBehind;
	}

}
