package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * useradv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useradv", schema = "health")
public class Useradv implements java.io.Serializable {

		// Fields
		private String userid;
		private String useradv;
		private Integer verinfo;

		// Constructors
		/** default constructor */
		public Useradv() {
		}
		

		/** minimal constructor */
		public Useradv(String userid) {
			this.userid = userid;
		}
		

		/** full constructor */
		public Useradv(String userid, String useradv, Integer verinfo) {
			this.userid = userid;
			this.useradv = useradv;
			this.verinfo = verinfo;
		}

		// Property
		@Id
		@Column(name = "userid")
		public String getUserid() {
			return userid;
		}

		@Column(name = "useradv")
		public String getUseradv() {
			return useradv;
		}
		
		@Column(name = "verinfo")
		public Integer getVerinfo() {
			return verinfo;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public void setUseradv(String useradv) {
			this.useradv = useradv;
		}

		public void setVerinfo(Integer verinfo) {
			this.verinfo = verinfo;
		}

}
