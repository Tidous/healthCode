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

    @Autowired
    private BirthdateService birthdateService;

    public String getBirdateInfo() {
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
            this.bufferedCase = suman + sumbn.toString() + sumcn + sumdn + sumen;
        } else {
            String sumas = birdateInfo.getSumas().toString();
            Integer sumb1s = birdateInfo.getSumb1s();
            Integer sumb2s = birdateInfo.getSumb2s();
            Integer sumbs = sumb1s + sumb2s;
            String sumcs = birdateInfo.getSumcs().toString();
            String sumds = birdateInfo.getSumds().toString();
            String sumes = birdateInfo.getSumes().toString();
            this.bufferedCase = sumas + sumbs.toString() + sumcs + sumds + sumes;
        }

        after();
        print();

        return SUCCESS;
    }

    public String getSysdateInfo() {
        Birthdate sysdateInfo = birthdateService.getSysdateInfo(sysday, systime);
        if (location.equals("N")) {
            String suman = sysdateInfo.getSuman().toString();
            Integer sumb1n = sysdateInfo.getSumb1n();
            Integer sumb2n = sysdateInfo.getSumb2n();
            Integer sumbn = (sumb1n + sumb2n);
            String sumcn = sysdateInfo.getSumcn().toString();
            String sumdn = sysdateInfo.getSumdn().toString();
            String sumen = sysdateInfo.getSumen().toString();
            this.currentCase = suman + sumbn.toString() + sumcn + sumdn + sumen;
        } else {
            String sumas = sysdateInfo.getSumas().toString();
            Integer sumb1s = sysdateInfo.getSumb1s();
            Integer sumb2s = sysdateInfo.getSumb2s();
            Integer sumbs = sumb1s + sumb2s;
            String sumcs = sysdateInfo.getSumcs().toString();
            String sumds = sysdateInfo.getSumds().toString();
            String sumes = sysdateInfo.getSumes().toString();
            this.currentCase = sumas + sumbs.toString() + sumcs + sumds + sumes;
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
}
