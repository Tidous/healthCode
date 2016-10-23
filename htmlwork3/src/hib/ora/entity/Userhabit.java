package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userhabit", schema = "health")
public class Userhabit implements java.io.Serializable {

	// Fields
    private String user;

    private String habit;
    private String other;
    private Integer verinfo;
    
    public Userhabit() {

	}
    
    public Userhabit(Integer userid) {

		this.user = user;
	}
    
    public Userhabit(String userid, String diet,String habit, String other, Integer verinfo) {

		this.user = user;
		this.habit = habit;
		this.other = other;
		this.verinfo = verinfo;
	}

    // Property
 	@Id
 	@Column(name = "user")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
