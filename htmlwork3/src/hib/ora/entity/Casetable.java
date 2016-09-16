package hib.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * casetable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "casetable", schema = "health")
public class Casetable implements java.io.Serializable {

	// Fields
	private String maincase;
	private String subcase;
	private String description;
	private String diet;
	private String edescription;
	private String ediet;
	private String incrementallink;

	// Constructors
	/** default constructor */
	public Casetable() {
	}

	/** minimal constructor */
	public Casetable(String maincase, String subcase) {
		this.maincase = maincase;
		this.subcase = subcase;
	}

	/** full constructor */
	public Casetable(String maincase, String subcase, String description,
			String diet, String edescription, String ediet,
			String incrementallink) {

		this.maincase = maincase;
		this.subcase = subcase;
		this.description = description;
		this.diet = diet;
		this.edescription = edescription;
		this.ediet = ediet;
		this.incrementallink = incrementallink;
	}

	// Property
	@Id
	@Column(name = "maincase")
	public String getMaincase() {
		return maincase;
	}

	@Id
	@Column(name = "subcase")
	public String getSubcase() {
		return subcase;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@Column(name = "diet")
	public String getDiet() {
		return diet;
	}

	@Column(name = "edescription")
	public String getEdescription() {
		return edescription;
	}

	@Column(name = "ediet")
	public String getEdiet() {
		return ediet;
	}

	@Column(name = "incrementallink")
	public String getIncrementallink() {
		return incrementallink;
	}

	public void setMaincase(String maincase) {
		this.maincase = maincase;
	}

	public void setSubcase(String subcase) {
		this.subcase = subcase;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public void setEdiet(String ediet) {
		this.ediet = ediet;
	}

	public void setIncrementallink(String incrementallink) {
		this.incrementallink = incrementallink;
	}

}