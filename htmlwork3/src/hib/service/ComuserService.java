package hib.service;

import hib.ora.entity.Comuser;

import java.util.List;

public interface ComuserService {
	
	public List<Comuser> find(String hql);
	
	public List<Comuser> find(String hql, List<Object> param);
	
	public void update(String hql, List<Object> param);
	
	public void save(Comuser sysUser);
	
	public void update(Comuser sysUser);
	
	public int getMaxUserId();
	
	public List<Comuser> findAllUser();
	
	public Comuser findUserByName(String user);
	
	public void updatePassword(Integer id, String password);
	
	public Comuser findUserById(Integer id);

	public Comuser findUserByPhone(String phone);
	
	public Comuser userLogin(String user, String password);
	
	public Comuser checkuser(String user, String mobile);
	
}

