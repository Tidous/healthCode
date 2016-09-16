package hib.ora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * date entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "birthdate", schema = "health")
public class Birthdate implements java.io.Serializable {

	// Fields
	private Date startdate;
	private Date enddate;
	private Integer category;
	private String year;
	private Integer specialflag;
	private Integer suman;
	private Integer sumb1n;
	private Integer sumb2n;
	private Integer sumcn;
	private Integer sumdn;
	private Integer sumen;
	private Integer sumas;
	private Integer sumb1s;
	private Integer sumb2s;
	private Integer sumcs;
	private Integer sumds;
	private Integer sumes;
	private String datecol;

	// Constructors

	/** default constructor */
	public Birthdate() {
	}
	
	/** minimal constructor */
	public Birthdate(Date startdate, Date enddate) {
		this.startdate = startdate;
		this.enddate = enddate;
	}


	/** full constructor */
	public Birthdate(Date startdate, Date enddate, Integer category,
			String year, Integer specialflag, Integer suman, Integer sumb1n,
			Integer sumb2n, Integer sumcn, Integer sumdn, Integer sumen,
			Integer sumas, Integer sumb1s, Integer sumb2s, Integer sumcs,
			Integer sumds, Integer sumes, String datecol) {

		this.startdate = startdate;
		this.enddate = enddate;
		this.category = category;
		this.year = year;
		this.specialflag = specialflag;
		this.suman = suman;
		this.sumb1n = sumb1n;
		this.sumb2n = sumb2n;
		this.sumcn = sumcn;
		this.sumdn = sumdn;
		this.sumen = sumen;
		this.sumas = sumas;
		this.sumb1s = sumb1s;
		this.sumb2s = sumb2s;
		this.sumcs = sumcs;
		this.sumds = sumds;
		this.sumes = sumes;
		this.datecol = datecol;
	}

	// Property
	@Id
	@Column(name = "startdate")
	public Date getStartdate() {
		return startdate;
	}

	@Id
	@Column(name = "enddate")
	public Date getEnddate() {
		return enddate;
	}

	@Column(name = "category")
	public Integer getCategory() {
		return category;
	}

	@Column(name = "year")
	public String getYear() {
		return year;
	}

	@Column(name = "specialflag")
	public Integer getSpecialflag() {
		return specialflag;
	}

	@Column(name = "suman")
	public Integer getSuman() {
		return suman;
	}

	@Column(name = "sumb1n")
	public Integer getSumb1n() {
		return sumb1n;
	}

	@Column(name = "sumb2n")
	public Integer getSumb2n() {
		return sumb2n;
	}

	@Column(name = "sumcn")
	public Integer getSumcn() {
		return sumcn;
	}

	@Column(name = "sumdn")
	public Integer getSumdn() {
		return sumdn;
	}

	@Column(name = "sumen")
	public Integer getSumen() {
		return sumen;
	}

	@Column(name = "sumas")
	public Integer getSumas() {
		return sumas;
	}

	@Column(name = "sumb1s")
	public Integer getSumb1s() {
		return sumb1s;
	}

	@Column(name = "sumb2s")
	public Integer getSumb2s() {
		return sumb2s;
	}

	@Column(name = "sumcs")
	public Integer getSumcs() {
		return sumcs;
	}

	@Column(name = "sumds")
	public Integer getSumds() {
		return sumds;
	}

	@Column(name = "sumes")
	public Integer getSumes() {
		return sumes;
	}

	@Column(name = "datecol")
	public String getDatecol() {
		return datecol;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setSpecialflag(Integer specialflag) {
		this.specialflag = specialflag;
	}

	public void setSuman(Integer suman) {
		this.suman = suman;
	}

	public void setSumb1n(Integer sumb1n) {
		this.sumb1n = sumb1n;
	}

	public void setSumb2n(Integer sumb2n) {
		this.sumb2n = sumb2n;
	}

	public void setSumcn(Integer sumcn) {
		this.sumcn = sumcn;
	}

	public void setSumdn(Integer sumdn) {
		this.sumdn = sumdn;
	}

	public void setSumen(Integer sumen) {
		this.sumen = sumen;
	}

	public void setSumas(Integer sumas) {
		this.sumas = sumas;
	}

	public void setSumb1s(Integer sumb1s) {
		this.sumb1s = sumb1s;
	}

	public void setSumb2s(Integer sumb2s) {
		this.sumb2s = sumb2s;
	}

	public void setSumcs(Integer sumcs) {
		this.sumcs = sumcs;
	}

	public void setSumds(Integer sumds) {
		this.sumds = sumds;
	}

	public void setSumes(Integer sumes) {
		this.sumes = sumes;
	}

	public void setDatecol(String datecol) {
		this.datecol = datecol;
	}

}