package hib.service;

import java.util.List;
import hib.ora.entity.Userinfo;

public interface UserinfoService {

    public List<Userinfo> find(String hql);
	
	public List<Userinfo> find(String hql, List<Object> param);

	public void save(Userinfo userinfo);

    public Userinfo findUserByKey(String id);
    
    public List<Userinfo> findUserById(String id);
	
	public void update(Userinfo userinfo);
	
	public void updateInfo(Userinfo userinfo);

	public void delete(Userinfo userinfo);
}
