package hib.service;

import java.util.List;
import hib.ora.entity.Userhabit;

public interface UserhabitService {
	
    public List<Userhabit> find(String hql);
	
	public List<Userhabit> find(String hql, List<Object> param);
	
	public void save(Userhabit userhabit);
	
    public Userhabit findUserById(Integer id);
	
	public void update(String hql, List<Object> param);
	
	public void updateHabit(Userhabit userhabit);

}
