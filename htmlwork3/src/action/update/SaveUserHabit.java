package action.update;

import hib.ora.entity.Userhabit;
import hib.service.UserhabitService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class SaveUserHabit extends AbstractJsonLogAction {

	private Integer userid;
	private String habit;
	private String other;
	private Integer verinfo;
	
	@Autowired
	private UserhabitService userhabitService;
	
	public String execute() {
		before();
		
		Userhabit userhabit = null;
		
		try {
			userhabit = userhabitService.findUserById(userid);
			if (userhabit != null) {
				verinfo = userhabit.getVerinfo() + 1;
				update();
			}
			else {
				verinfo = 1;
				save();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		after();
		print();
		
		return SUCCESS;
	}
	
	private String save() {
		before();
		
		Userhabit userhabit = new Userhabit();
		setUserHab(userhabit);
		
		try {
			userhabitService.save(userhabit);
			Userhabit reshabit = null;
			reshabit = userhabitService.findUserById(userid);
			if (reshabit != null) {
				this.retmsg = "success";
			}
			else {
				this.retmsg = "fail";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		after();
		print();
		
		return SUCCESS;
	}
	
	private String update() {
        before();
		
		Userhabit userhabit = new Userhabit();
		setUserHab(userhabit);
		
		try {
			userhabitService.updateHabit(userhabit);
			Userhabit reshabit = null;
			reshabit = userhabitService.findUserById(userid);
			if (reshabit.getVerinfo() == verinfo) {
				this.retmsg = "success";
			}
			else {
				this.retmsg = "fail";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		after();
		print();
		
		return SUCCESS;
	}
	
	private void setUserHab(Userhabit userhabit) {
		userhabit.setUserid(userid);
		userhabit.setHabit(habit);
		userhabit.setOther(other);
		userhabit.setVerinfo(verinfo);	
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
