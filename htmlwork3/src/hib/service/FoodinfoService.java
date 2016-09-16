package hib.service;

import hib.ora.entity.Foodinfo;

import java.util.List;


public interface FoodinfoService {
	
    public List<Foodinfo> find(String hql);
	
	public List<Foodinfo> find(String hql, List<Object> param);
	
	public Foodinfo findFoodById(Integer id);
}

