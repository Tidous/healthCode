package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo", schema = "health")
public class Userinfo implements java.io.Serializable {

	// Fields
	private String userid;

	private String username;
	private String relationship;
	private String sex;
	private String idno;
	private String phone;
	private String mail;
	private String zcode;
	private String job;
	private String address;
	private String city;
	private String province;
	private String comuser;

	// Constructors
	/** default constructor */
	public Userinfo() {

	}
	
	public Userinfo(String userid) {
		this.userid = userid;
		this.username = username;
		this.idno = idno;
	}
	
	public Userinfo(String userid, String username, String relationship,
			String sex, String idno, String phone, String mail, String zcode,
			String job, String address, String city, String province, String comuser) {

		this.userid = userid;
		this.username = username;
		this.relationship = relationship;
		this.sex = sex;
		this.idno = idno;
		this.phone = phone;
		this.mail = mail;
		this.zcode = zcode;
		this.job = job;
		this.address = address;
		this.city = city;
		this.province = province;
		this.comuser = comuser;
	}

	// Property
	@Id
	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Id
	@Column(name = "idno")
	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	@Column(name = "relationship")
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "zcode")
	public String getZcode() {
		return zcode;
	}

	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	@Column(name = "job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "comuser")
	public String getComuser() {
		return comuser;
	}

	public void setComuser(String comuser) {
		this.comuser = comuser;
	}
}
