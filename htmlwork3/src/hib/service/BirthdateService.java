package hib.service;

import hib.ora.entity.Birthdate;

import java.util.List;

public interface BirthdateService {
	
	public List<Birthdate> find(String hql, List<Object> param);
	
	public Birthdate getUserBirthInfo(String date, String time);
	
	public Birthdate getSysdateInfo(String date, String time);

	public List<Birthdate> getYearInfo(String date, String time);
	
}

