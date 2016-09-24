package hib.service.impl;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Foodinfo;
import hib.service.FoodinfoService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FoodinfoService")
public class FoodinfoServiceImpl implements FoodinfoService {
	@Autowired
	BaseDAO<Foodinfo> baseDAO;
	
	@Override
	public List<Foodinfo> find(String hql, List<Object> param) {
		
		return baseDAO.find(hql,param);
	}

	@Override
	public List<Foodinfo> find(String hql) {

		return baseDAO.find(hql);
	}
	
	@Override
	public void update(Foodinfo foodinfo) {
		
		baseDAO.update(foodinfo);
		
	}

	@Override
	public void update(String hql) {

		baseDAO.update(hql);

	}
	
	@Override
	public void delete(Foodinfo foodinfo) {
		
		baseDAO.delete(foodinfo);
		
	}
	
	public Foodinfo findFoodById(Integer id)  {

		String Hql = "from Foodinfo f where f.id=?";

		List<Object> param = new ArrayList<Object>();

		param.add(id);

		List<Foodinfo> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	
}
