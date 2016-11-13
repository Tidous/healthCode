package action.query;


import java.util.List;

import hib.ora.entity.Userinfo;
import hib.service.UserinfoService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class QueryUserFileAction extends AbstractJsonLogAction {

    private String userid;

	private String name;
	private String idno;

	private String relationship;
	private String sex;
	private String phone;
	private String mail;
	private String zcode;
	private String job;
	private String address;

	private List<Userinfo> list;
	
	@Autowired
	private UserinfoService userinfoService;

	public String query() {
		before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (userinfoService != null) {
			Userinfo userinfo = null;
			userinfo = userinfoService.findUserByKey(userid, name, idno);
			if (userinfo != null) {
				this.retmsg = "success";
				this.relationship = userinfo.getRelationship();
				this.sex = userinfo.getSex();
				this.phone = userinfo.getPhone();
				this.mail = userinfo.getMail();
				this.zcode = userinfo.getZcode();
				this.job = userinfo.getJob();
				this.address = userinfo.getAddress();
			}
			else {
				this.retmsg = "fail";
			}
		}
		
		after();
		print();
		return SUCCESS;
	}
	
	public String queryList() {
		before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (userinfoService != null) {
			this.list = userinfoService.findUserById(userid);
			if (this.list != null && this.list.size()>0) {
				this.retmsg = "success";
			}
			else {
				this.retmsg = "fail";
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getZcode() {
		return zcode;
	}

	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Userinfo> getList() {
		return list;
	}
}
