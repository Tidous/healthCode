package action.query;

import action.AbstractJsonLogAction;
import hib.ora.entity.Birthdate;
import hib.ora.entity.Casetable;
import hib.service.BirthdateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * Created by dell on 2016/11/19.
 */
public class QueryBirthdayInfoAction extends AbstractJsonLogAction {

    private String birthday;
    private String time;
    private String location;
    private String bufferedCase;
    private String currentCase;
    private String sysday;
    private String systime;
    private String bufferBlood;
    private String currentBlood;

    @Autowired
    private BirthdateService birthdateService;

    public String getBirdateInfo() {
        handleNullField();
        before();

        Birthdate birdateInfo = birthdateService.getUserBirthInfo(birthday, time);
        if (location.equals("N")) {
            String suman = birdateInfo.getSuman().toString();
            Integer sumb1n = birdateInfo.getSumb1n();
            Integer sumb2n = birdateInfo.getSumb2n();
            Integer sumbn = (sumb1n + sumb2n);
            String sumcn = birdateInfo.getSumcn().toString();
            String sumdn = birdateInfo.getSumdn().toString();
            String sumen = birdateInfo.getSumen().toString();
            Double blood = birdateInfo.getSuman()*0.1+birdateInfo.getSumb1n()*0.9+birdateInfo.getSumb2n()*0.9+birdateInfo.getSumcn()*0.9+birdateInfo.getSumdn()*0.9+birdateInfo.getSumen()*0.1;
            this.bufferedCase = suman + sumbn.toString() + sumcn + sumdn + sumen;
            this.bufferBlood = blood.toString();
        } else {
            String sumas = birdateInfo.getSumas().toString();
            Integer sumb1s = birdateInfo.getSumb1s();
            Integer sumb2s = birdateInfo.getSumb2s();
            Integer sumbs = sumb1s + sumb2s;
            String sumcs = birdateInfo.getSumcs().toString();
            String sumds = birdateInfo.getSumds().toString();
            String sumes = birdateInfo.getSumes().toString();
            Double blood = birdateInfo.getSumas()*0.1+birdateInfo.getSumb1s()*0.9+birdateInfo.getSumb2s()*0.9+birdateInfo.getSumcs()*0.9+birdateInfo.getSumds()*0.9+birdateInfo.getSumes()*0.1;
            this.bufferedCase = sumas + sumbs.toString() + sumcs + sumds + sumes;
            this.bufferBlood = blood.toString();
        }

        after();
        print();

        return SUCCESS;
    }

    public String getSysdateInfo() {
        handleNullField();
        Birthdate sysdateInfo = birthdateService.getSysdateInfo(sysday, systime);
        if (location.equals("N")) {
            String suman = sysdateInfo.getSuman().toString();
            Integer sumb1n = sysdateInfo.getSumb1n();
            Integer sumb2n = sysdateInfo.getSumb2n();
            Integer sumbn = (sumb1n + sumb2n);
            String sumcn = sysdateInfo.getSumcn().toString();
            String sumdn = sysdateInfo.getSumdn().toString();
            String sumen = sysdateInfo.getSumen().toString();
            Double blood = sysdateInfo.getSuman()*0.9+sysdateInfo.getSumb1n()*0.1+sysdateInfo.getSumb2n()*0.1+sysdateInfo.getSumcn()*0.1+sysdateInfo.getSumdn()*0.1+sysdateInfo.getSumen()*0.1;
            this.currentCase = suman + sumbn.toString() + sumcn + sumdn + sumen;
            this.currentBlood = blood.toString();
        } else {
            String sumas = sysdateInfo.getSumas().toString();
            Integer sumb1s = sysdateInfo.getSumb1s();
            Integer sumb2s = sysdateInfo.getSumb2s();
            Integer sumbs = sumb1s + sumb2s;
            String sumcs = sysdateInfo.getSumcs().toString();
            String sumds = sysdateInfo.getSumds().toString();
            String sumes = sysdateInfo.getSumes().toString();
            Double blood = sysdateInfo.getSumas()*0.9+sysdateInfo.getSumb1s()*0.1+sysdateInfo.getSumb2s()*0.1+sysdateInfo.getSumcs()*0.1+sysdateInfo.getSumds()*0.1+sysdateInfo.getSumes()*0.1;
            this.currentCase = sumas + sumbs.toString() + sumcs + sumds + sumes;
            this.currentBlood = blood.toString();
        }
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
        } else {
            time = time + ":00";
        }

        sysday = sysDate;
        systime = hour + ":" + minute + ":" + second;

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

    public String getBufferedCase() {
        return bufferedCase;
    }

    public String getCurrentCase() {
        return currentCase;
    }

    public String getSysday() {
        return sysday;
    }

    public void setSysday(String sysday) {
        this.sysday = sysday;
    }

    public String getSystime() {
        return systime;
    }

    public void setSystime(String systime) {
        this.systime = systime;
    }

    public String getBufferBlood() {
        return bufferBlood;
    }

    public void setBufferBlood(String bufferBlood) {
        this.bufferBlood = bufferBlood;
    }

    public String getCurrentBlood() {
        return currentBlood;
    }

    public void setCurrentBlood(String currentBlood) {
        this.currentBlood = currentBlood;
    }
}
