package action;

import hib.service.BirthdateService;
import hib.service.CasetableService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dell on 2017/1/2.
 */
public class GetBirthdayCorrectInfoAction extends AbstractJsonLogAction{

    private String date;
    private Boolean isNeedDateTime;

    @Autowired
    private BirthdateService birthdateService;

    public String isNeedDateTime(){

        isNeedDateTime = birthdateService.isNeedDateTime(date);

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

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public Boolean getIsNeedDateTime() {
        return isNeedDateTime;
    }

}
