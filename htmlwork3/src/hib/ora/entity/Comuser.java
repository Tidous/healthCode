package hib.ora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * user entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comuser", schema = "health")
public class Comuser implements java.io.Serializable {

	// Fields
	private Integer uid;
	private String username;
	private String email;
	private String mobilephone;
	private String password;
	private Date createtime;
	private Date lastlogintime;
	private Date starttime;
	private Date endtime;
	private String bufferedcase;
	private String relateduser;
	private Integer ismasteruser;
	private Date column6;

	// Constructors

	/** default constructor */
	public Comuser() {
	}
	
	/** minimal constructor */
	public Comuser(Integer uid) {
		this.uid = uid;
	}
	
	/** full constructor */
	public Comuser(Integer uid, String username, String email,
			String mobilephone, String password, Date createtime,
			Date lastlogintime, Date starttime, Date endtime,
			String bufferedcase, String relateduser, Integer ismasteruser,
			Date column6) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.mobilephone = mobilephone;
		this.password = password;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.starttime = starttime;
		this.endtime = endtime;
		this.bufferedcase = bufferedcase;
		this.relateduser = relateduser;
		this.ismasteruser = ismasteruser;
		this.column6 = column6;
	}
	
	// Property
	@Id
	@Column(name = "uid")
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobilephone")
	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "createtime")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "lastlogintime")
	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	@Column(name = "starttime")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "bufferedcase")
	public String getBufferedcase() {
		return bufferedcase;
	}

	public void setBufferedcase(String bufferedcase) {
		this.bufferedcase = bufferedcase;
	}

	@Column(name = "relateduser")
	public String getRelateduser() {
		return relateduser;
	}

	public void setRelateduser(String relateduser) {
		this.relateduser = relateduser;
	}

	@Column(name = "ismasteruser")
	public Integer getIsmasteruser() {
		return ismasteruser;
	}

	public void setIsmasteruser(Integer ismasteruser) {
		this.ismasteruser = ismasteruser;
	}

	@Column(name = "column6")
	public Date getColumn6() {
		return column6;
	}

	public void setColumn6(Date column6) {
		this.column6 = column6;
	}
	
}