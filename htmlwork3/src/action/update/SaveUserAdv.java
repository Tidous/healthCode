package action.update;

import hib.ora.entity.Useradv;
import hib.service.UseradvService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class SaveUserAdv extends AbstractJsonLogAction {
    
	private String adv;
	private Integer verinfo;
	private String userid;
	
	private String result;
	
	@Autowired
	private UseradvService useradvService;
	
	public String save() {
    	before();
    	
    	Useradv useradv = new Useradv();
    	
    	Useradv resadv = useradvService.findUserById(userid);
    	
    	if (resadv != null) {
    		if (useradvService != null) {
    			verinfo = resadv.getVerinfo() + 1;
    			try {
        			useradvService.updateAdv(userid, adv, verinfo);
    			} catch (NullPointerException e) {
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
                resadv = useradvService.findUserById(userid);
    			
    			if (resadv.getVerinfo() == verinfo) {
    				result = "1";
    			}
    			else {
    				result = "3"; //更新失败
    			}
    		}
		}
    	else {
    		if (useradvService != null) {
    			verinfo = 1;
        		useradv.setUserid(userid);
        		useradv.setUseradv(adv);
        		useradv.setVerinfo(verinfo);
        		
        		try {
        			useradvService.save(useradv);
    			} catch (NullPointerException e) {
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        		
        		resadv = useradvService.findUserById(userid);
    			
    			if (resadv != null) {
    				result = "1";
    			}
    			else {
    				result = "0"; //新增失败，未找到该记录
    			}
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

	public String getAdv() {
		return adv;
	}

	public void setAdv(String adv) {
		this.adv = adv;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getResult() {
		return result;
	}
}
