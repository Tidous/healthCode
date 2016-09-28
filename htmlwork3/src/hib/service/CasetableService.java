package hib.service;

import java.util.List;

import hib.ora.entity.Casetable;
import hib.ora.entity.Birthdate;

public interface CasetableService {
	public List<Casetable> find(String hql);

    public List<Casetable> find(String hql, List<Object> param);
    
    public void update(String hql, List<Object> param);
	
	public void update(Casetable casetable);
	
	public Casetable dealwithFront(String date, String hemisphere, Birthdate birdateInfo);
	
	public Casetable dealwithBehind(String date, String hemisphere, Birthdate birdateInfo, Birthdate sysdateInfo);
	
	public void updateCaseElement(String key, String value, String m, String s);
	
	public List<Casetable> findAllCase();
	
	public List<Casetable> findCaseWithFilter(String m, String s);
}
