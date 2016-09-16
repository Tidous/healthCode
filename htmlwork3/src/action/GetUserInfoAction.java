package action;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.springframework.beans.factory.annotation.Autowired;

public class GetUserInfoAction extends AbstractJsonLogAction {
	
	private String username;
	private String mobile;
	
	private String result;
	
	@Autowired
	ComuserService comuserService;

	public String check() {
		handleNullField();
		before();
		
		Comuser user = null;

		try {
			user = comuserService.checkuser(username, mobile);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			result = "1";
		}
		else {
			result = "0"; //未找到该用户
		}
		
		after();
		print();

		return SUCCESS;

	}
	
	public String execute() {
		
		handleNullField();
		before();
		
		Comuser user = null;

		try {
			user = comuserService.findUserByName(username);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			result = "1";
		}
		else {
			result = "0"; //未找到该用户
		}
		
		after();
		print();

		return SUCCESS;
	}
	
	/**
    *
    */
	private void handleNullField() {
		if (null == username) {
			username = "";
		}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
