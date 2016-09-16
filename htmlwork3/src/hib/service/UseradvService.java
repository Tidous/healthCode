package hib.service;

import java.util.List;
import hib.ora.entity.Useradv;

public interface UseradvService {
	
    public List<Useradv> find(String hql);
	
	public List<Useradv> find(String hql, List<Object> param);

	public void save(Useradv useradv);
	
	public Useradv findUserById(Integer id);
	
	public void update(String hql, List<Object> param);
	
	public void updateAdv(Integer userid, String adv, Integer ver);
}
