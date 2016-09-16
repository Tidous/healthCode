package action.update;

import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class UpdateUserPsd extends AbstractJsonLogAction {
	
	private String username;
	private String oldpsd;
	private String newpsd;
	
	private String result;
	
	@Autowired
	private ComuserService comuserService;

	public String updatepsd() {
    	before();
    	
    	Comuser user = null;

		try {
			user = comuserService.userLogin(username, oldpsd);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			Integer id = user.getUid();
			try {
				comuserService.updatePassword(id, newpsd);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			user = comuserService.userLogin(username, newpsd);
			if (user != null) {
				result = "1"; //未找到该用户
			}
			else {
				result = "3"; //修改失败
			}
		}
		else {
			result = "0"; //未找到该用户
			return SUCCESS;
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

	public String getOldpsd() {
		return oldpsd;
	}

	public void setOldpsd(String oldpsd) {
		this.oldpsd = oldpsd;
	}

	public String getNewpsd() {
		return newpsd;
	}

	public void setNewpsd(String newpsd) {
		this.newpsd = newpsd;
	}

}
