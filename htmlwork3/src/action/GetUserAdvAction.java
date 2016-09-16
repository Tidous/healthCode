package action;

import hib.ora.entity.Useradv;
import hib.service.UseradvService;

import org.springframework.beans.factory.annotation.Autowired;

public class GetUserAdvAction extends AbstractJsonLogAction {
	
	private Integer userid;
	private String adv;
	
	@Autowired
	private UseradvService useradvService;
	
	public String execute() {
		before();
		
		Useradv useradv = new Useradv(); 
		
		if (useradvService != null) {
			try {
				useradv = useradvService.findUserById(userid);
				this.adv = useradv.getUseradv();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
