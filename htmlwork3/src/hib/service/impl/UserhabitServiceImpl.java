package hib.service.impl;

import java.util.ArrayList;
import java.util.List;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Useradv;
import hib.ora.entity.Userhabit;
import hib.service.UserhabitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("userhabitService")
public class UserhabitServiceImpl implements UserhabitService  {

	@Autowired
	BaseDAO<Userhabit> baseDAO;
	
	@Override
	public List<Userhabit> find(String hql, List<Object> param) {
		
		return baseDAO.find(hql,param);
		
	}

	
	@Override
	public List<Userhabit> find(String hql) {

		return baseDAO.find(hql);
	}
	
	@Override
	public void update(String hql, List<Object> param) {
		
		baseDAO.update(hql,param);
		
	}

	@Override
	public void save(Userhabit userhabit){

		String Hql = "insert into userhabit(" +
				"userid," +
				"habit," +
				"other," +
				"verinfo" +") values(" +
				"?," +
				"?," +
				"?," +
				"?" + ")";
		
		Object[] param = new Object[4];
		
		if(userhabit.getUserid()!=null){
			
			param[0]=userhabit.getUserid();
			
		}else{ param[0]=000000; }
		
        if(userhabit.getHabit()!=null){
			
			param[1]=userhabit.getHabit();
			
		}else{ param[1]=""; }
        
        if(userhabit.getOther()!=null){
			
			param[2]=userhabit.getOther();
			
		}else{ param[2]=""; }
        
        if(userhabit.getVerinfo()!=null){
			
			param[3]=userhabit.getVerinfo();
			
		}else{ param[3]=""; }
		
		baseDAO.executeSql(Hql, param);	
	}
	
	public Userhabit findUserById(String userid)  {

		String Hql = "from Userhabit u where u.userid=?";

		List<Object> param = new ArrayList<Object>();

		param.add(userid);

		List<Userhabit> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	public void updateHabit(Userhabit userhabit)  {

		String Hql = "update Userhabit u set u.habit=?,u.other=?,u.verinfo=? where u.userid=?";

		List<Object> param = new ArrayList<Object>();
		
		param.add(userhabit.getHabit());
		
		param.add(userhabit.getOther());

		param.add(userhabit.getVerinfo());
		
		param.add(userhabit.getUserid());

		this.update(Hql ,param);
	}
}
