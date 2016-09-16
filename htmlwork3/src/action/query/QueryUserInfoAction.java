package action.query;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class QueryUserInfoAction extends AbstractJsonLogAction {
	
	private String username;
	private String mobile;
	private String password;
	
	@Autowired
	private ComuserService comuserService;

    public String execute() {
    	
    	before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (comuserService != null) {
			
			int maxId = comuserService.getMaxUserId();

			int uid = maxId + 1;
			
			Comuser user = new Comuser();
			user.setUid(uid);
			user.setUsername(username);
			user.setMobilephone(mobile);
			user.setPassword(password);

			comuserService.save(user);
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}