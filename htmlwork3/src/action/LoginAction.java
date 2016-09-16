package action;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginAction extends AbstractJsonLogAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4623920526163562259L;

	private String username;
	private String password;
	
	private Integer userid;
	
	private String result;

	@Autowired
	ComuserService comuserService;

	public String execute() {
		handleNullField();
		before();
		
		Comuser user = null;

		try {
			user = comuserService.userLogin(username, password);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			result = "1";
			userid = user.getUid();
		}
		else {
			result = "0"; //用户名或密码错误
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
		if (null == password) {
			password = "";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public Integer getUserid() {
		return userid;
	}


}
