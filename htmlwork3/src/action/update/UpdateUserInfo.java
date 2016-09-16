package action.update;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class UpdateUserInfo extends AbstractJsonLogAction {
	
	private String username;
	private String mobile;
	private String password;
	
	private String result;
	
	private Integer userid;
	
	@Autowired
	private ComuserService comuserService;

    public String execute() {
    	
    	before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (comuserService != null) {
			
			int maxId = comuserService.getMaxUserId();

			int uid = maxId + 1;
			
			Comuser user = null;

			try {
				user = comuserService.findUserByName(username);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (user != null) {
				result = "2";//该用户已经存在
				return SUCCESS;
			}
			
			user = new Comuser();
			user.setUid(uid);
			user.setUsername(username);
			user.setMobilephone(mobile);
			user.setPassword(password);
			
			try {
				comuserService.save(user);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Comuser newuser = comuserService.findUserById(uid);
			
			if (newuser != null) {
				result = "1";
				userid = newuser.getUid();
			}
			else {
				result = "0"; //新增失败，未找到该用户
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

	public String getResult() {
		return result;
	}

	public Integer getUserid() {
		return userid;
	}
}