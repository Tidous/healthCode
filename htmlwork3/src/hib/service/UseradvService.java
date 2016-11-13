package hib.service;

import hib.ora.entity.Useradv;

import java.util.List;

public interface UseradvService {
	
    public List<Useradv> find(String hql);
	
	public List<Useradv> find(String hql, List<Object> param);

	public void save(Useradv useradv);
	
	public Useradv findUserById(String id);
	
	public void update(String hql, List<Object> param);
	
	public void updateAdv(String userid, String adv, Integer ver);
}
