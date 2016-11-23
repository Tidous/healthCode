package action;

import action.mail.MailSendObserver;
import hib.ora.entity.Birthdate;
import hib.ora.entity.Casetable;
import hib.service.BirthdateService;
import hib.service.CasetableService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetNextYearCaseTable extends AbstractJsonLogAction {

    private String birthday;
    private String time;
    private String location;
    private Birthdate birdateInfo;
    private List<Birthdate> sysdateInfo;

    private String sysday;
    private String systime;
    private String caseSumList;
    private String startDateList;
    private String endDateList;

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

        sysdateInfo = birthdateService.getYearInfo(sysday, systime);

        for (int i=0;i<sysdateInfo.size();i++){
            this.caseSumList = caseSumList+";"+queryBehind(birthday, location, i);
            this.startDateList = startDateList+";"+sysdateInfo.get(i).getStartdate().toString();
            this.endDateList = endDateList+";"+sysdateInfo.get(i).getEnddate().toString();
        }

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
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(cal.YEAR,1);//用Calendar对年加1,绕开判断闰年
        now = cal.getTime();//还原为DATE

        SimpleDateFormat sd = new SimpleDateFormat("EEE");

        System.out.println("明年今天是  " + sd.format(now));

        String sysDate = dateFormat.format(now);

        if (null == birthday || birthday.isEmpty()) {
            birthday = sysDate;
        }
        if (null == time || time.isEmpty()) {
            time = "";
        } else {
            time = time + ":00";
        }

        sysday = sysDate;
        systime = hour + ":" + minute + ":" + second;

    }

    private String queryBehind(String date, String location, Integer i) {

        String caseSum = "";
        if (casetableService != null) {
            caseSum = casetableService.dealWithCaseSum(date, location, birdateInfo, sysdateInfo.get(i));
        }

        return caseSum;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCaseSumList() {
        return caseSumList;
    }

    public String getStartDateList() {
        return startDateList;
    }

    public String getEndDateList() {
        return endDateList;
    }
}
