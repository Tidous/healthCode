package action.query;

import action.AbstractJsonLogAction;
import hib.ora.entity.Birthdate;
import hib.ora.entity.Casetable;
import hib.ora.entity.Comuser;
import hib.service.BirthdateService;
import hib.service.ComuserService;
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
public class QueryUserBufferedInfo extends AbstractJsonLogAction {

    private String username;
    private String hometown;
    private String bufferedCase;
    private String birthday;

    @Autowired
    private ComuserService comuserService;

    public String getUserBufferedInfo() {
        before();

        Comuser user = comuserService.findUserByName(username);
        this.hometown = user.getHometown();
        this.birthday = user.getColumn6().toString();
        this.bufferedCase = user.getBufferedcase();

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getBufferedCase() {
        return bufferedCase;
    }

    public void setBufferedCase() {
        this.bufferedCase = bufferedCase;
    }
}