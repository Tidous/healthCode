package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * foodinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "foodinfo", schema = "health")
public class Foodinfo implements java.io.Serializable {

	// Fields
	private Integer id;
	private String fooddesc;
	private String fooddescen;

	// Constructors
	/** default constructor */
	public Foodinfo() {
	}

	/** minimal constructor */
	public Foodinfo(Integer id) {
		this.id = id;

	}

	/** full constructor */
	public Foodinfo(Integer id, String fooddesc, String fooddescen) {
		super();
		this.id = id;
		this.fooddesc = fooddesc;
		this.fooddescen = fooddescen;
	}

	// Property
	@Id
	@Column(name = "id")
	public Integer getid() {
		return id;
	}

	@Column(name = "fooddesc")
	public String getFooddesc() {
		return fooddesc;
	}

	@Column(name = "fooddescen")
	public String getfooddescen() {
		return fooddescen;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public void setFooddesc(String fooddesc) {
		this.fooddesc = fooddesc;
	}

	public void setfooddescen(String fooddescen) {
		this.fooddescen = fooddescen;
	}	

}