package action.update;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

import java.util.Date;

public class UpdateUserBirthday extends AbstractJsonLogAction {

    private String username;
    private String hometown;
    private Date column6;
    private String bufferedCase;

    private String result;

    @Autowired
    private ComuserService comuserService;

    public String updateBirthday() {
        before();

        try {
            comuserService.updateBirthday(username, column6, hometown, bufferedCase);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResult() {
        return result;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Date getColumn6() {
        return column6;
    }

    public void setColumn6(Date column6) {
        this.column6 = column6;
    }

    public String getBufferedCase() {
        return bufferedCase;
    }

    public void setBufferedCase(String bufferedCase) {
        this.bufferedCase = bufferedCase;
    }

}