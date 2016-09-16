package hib.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Comuser;
import hib.ora.entity.Useradv;
import hib.service.UseradvService;

@Service("UseradvService")
public class UseradvServiceImpl implements UseradvService {

	@Autowired
	BaseDAO<Useradv> baseDAO;
	
	@Override
	public List<Useradv> find(String hql, List<Object> param) {
		
		return baseDAO.find(hql,param);
		
	}

	
	@Override
	public List<Useradv> find(String hql) {

		return baseDAO.find(hql);
	}
	
	@Override
	public void update(String hql, List<Object> param) {
		
		baseDAO.update(hql,param);
		
	}
	
	@Override
	public void save(Useradv useradv){

		String Hql = "insert into health.useradv(" +
				"userid," +
				"useradv," +
				"verinfo" +") values(" +
				"?," +
				"?," +
				"?" + ")";
		
		Object[] param = new Object[3];
		
		if(useradv.getUserid()!=null){
			
			param[0]=useradv.getUserid();
			
		}else{ param[0]=000000; }
		
		if(useradv.getUseradv()!=null){
			
			param[1]=useradv.getUseradv();
			
		}else{ param[1]=""; }
		
        if(useradv.getVerinfo()!=null){
			
			param[2]=useradv.getVerinfo();
			
		}else{ param[2]=0; }
		
		baseDAO.executeSql(Hql, param);	
	}
	
	public Useradv findUserById(Integer id)  {

		String Hql = "from Useradv c where c.userid=?";

		List<Object> param = new ArrayList<Object>();

		param.add(id);

		List<Useradv> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	public void updateAdv(Integer userid, String adv, Integer ver)  {

		String Hql = "update Useradv c set c.useradv=?, c.verinfo=? where c.userid=?";

		List<Object> param = new ArrayList<Object>();

		param.add(adv);
		
		param.add(ver);

		param.add(userid);

		this.update(Hql ,param);
	}
}
