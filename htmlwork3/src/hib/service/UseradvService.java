package hib.service;

import hib.ora.entity.Useradv;

import java.util.List;

public interface UseradvService {
	
    public List<Useradv> find(String hql);
	
	public List<Useradv> find(String hql, List<Object> param);

	public void save(Useradv useradv);
	
	public Useradv findUserById(Integer id);
	
	public void update(String hql, List<Object> param);
	
	public void updateAdv(Integer userid, String adv, Integer ver);
}
