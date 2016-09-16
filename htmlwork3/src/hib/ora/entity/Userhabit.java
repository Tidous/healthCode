package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userhabit", schema = "health")
public class Userhabit implements java.io.Serializable {

	// Fields
    private Integer userid;

    private String habit;
    private String other;
    private Integer verinfo;
    
    public Userhabit() {

	}
    
    public Userhabit(Integer userid) {

		this.userid = userid;
	}
    
    public Userhabit(Integer userid, String diet,String habit, String other, Integer verinfo) {

		this.userid = userid;
		this.habit = habit;
		this.other = other;
		this.verinfo = verinfo;
	}

    // Property
 	@Id
 	@Column(name = "userid")
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "habit")
	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}
	
	@Column(name = "other")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "verinfo")
	public Integer getVerinfo() {
		return verinfo;
	}

	public void setVerinfo(Integer verinfo) {
		this.verinfo = verinfo;
	}
}
