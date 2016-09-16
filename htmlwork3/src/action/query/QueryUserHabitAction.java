package action.query;


import hib.ora.entity.Userhabit;
import hib.service.UserhabitService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class QueryUserHabitAction extends AbstractJsonLogAction {

	private Integer userid;
	private String habit;
	private String other;
	
	@Autowired
	private UserhabitService userhabitService;

	public String query() {
		before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (userhabitService != null) {
			Userhabit userhabit = null;
			userhabit = userhabitService.findUserById(userid);
			if (userhabit != null) {
				this.habit = userhabit.getHabit();
				this.other = userhabit.getOther();
			}
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
