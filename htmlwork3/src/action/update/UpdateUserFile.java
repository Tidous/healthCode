package action.update;

import hib.ora.entity.Userinfo;
import hib.service.UserinfoService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;
import action.common.CreateUserFile;

public class UpdateUserFile extends AbstractJsonLogAction {

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
	private String comuser;
	
	@Autowired
	private UserinfoService userinfoService;
	
	public String execute() {
		before();
		
		Userinfo userinfo = null;
		
		try {
			userinfo = userinfoService.findUserByKey(name);
			if (userinfo != null) {
				update();
				if (this.retmsg.equalsIgnoreCase("fail")) {	
					return SUCCESS;
				}
			}
			else {
				save();
                if (this.retmsg.equalsIgnoreCase("fail")) {
                	return SUCCESS;
				}
                else {
                	userinfo = userinfoService.findUserByKey(name);
                }
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CreateUserFile cf = new CreateUserFile();
		cf.writeFile(userinfo);

		after();
		print();
       
        return SUCCESS;
	}
	
	public String delete() {	
        before();
        
        String res = null;
		
		Userinfo userinfo = new Userinfo();
		setUserInfo(userinfo);
		
		try {
			userinfoService.delete(userinfo);
			userinfo = userinfoService.findUserByKey(name);
			if (userinfo == null) {
				res = "success";
			}
			else {
				res = "fail";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//delete the file on the server
		CreateUserFile cf = new CreateUserFile();
		cf.delete(name,idno);
		String delmsg = cf.retmsg;
		if (res == "success" && delmsg == "success") {
			this.retmsg = "success";
		}
		else {
			this.retmsg = "fail";
		}
		after();
		print();
       
        return SUCCESS;
	}
	
	private void save() {
		
		Userinfo userinfo = new Userinfo();
		setUserInfo(userinfo);
		
		try {
			userinfoService.save(userinfo);
			Userinfo resinfo = null;
			resinfo = userinfoService.findUserByKey(name);
			if (resinfo != null) {
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
	}
	
	private void update() {
		
		Userinfo userinfo = new Userinfo();
		setUserInfo(userinfo);
		
		try {
			userinfoService.updateInfo(userinfo);
			this.retmsg = "success";
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setUserInfo(Userinfo userinfo) {

		userinfo.setUserid(userid);
		userinfo.setUsername(name);
		userinfo.setRelationship(relationship);
		userinfo.setSex(sex);
		userinfo.setIdno(idno);
		userinfo.setPhone(phone);
		userinfo.setMail(mail);
		userinfo.setZcode(zcode);
		userinfo.setJob(job);
		userinfo.setAddress(address);
		userinfo.setComuser(comuser);
	}

	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
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

	public String getComuser() {
		return comuser;
	}

	public void setComuser(String comuser) {
		this.comuser = comuser;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
