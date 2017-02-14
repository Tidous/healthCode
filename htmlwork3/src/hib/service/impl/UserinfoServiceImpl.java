package hib.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Userhabit;
import hib.ora.entity.Userinfo;
import hib.service.UserinfoService;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService{

		@Autowired
	BaseDAO<Userinfo> baseDAO;
	
	@Override
	public List<Userinfo> find(String hql, List<Object> param) {
		
		return baseDAO.find(hql,param);
		
	}

	
	@Override
	public List<Userinfo> find(String hql) {

		return baseDAO.find(hql);
	}
	
	@Override
	public void update(Userinfo userinfo) {
		
		baseDAO.update(userinfo);
		
	}
	
	@Override
	public void delete(Userinfo userinfo) {
		
		baseDAO.delete(userinfo);
		
	}

	@Override
	public void save(Userinfo userinfo){

		String Hql = "insert into health.userinfo(" +
				"userid," +
				"username," +
				"relationship," +
				"sex," +
				"idno," +
				"phone," +
				"mail," +
				"zcode," +
				"job," +
				"address" +
				"comuser," +") values(" +
				"?," +
				"?," +
				"?," +
				"?," +
				"?," +
				"?," +
				"?," +
				"?," +
				"?," +
				"?" +
				"?," +")";
		
		Object[] param = new Object[10];

		if(userinfo.getUsername()!=null){

			param[0]=userinfo.getUsername();

		}else{ param[1]=""; }

		if(userinfo.getUsername()!=null){
			
			param[1]=userinfo.getUsername();
			
		}else{ param[1]=""; }
		
        if(userinfo.getRelationship()!=null){
			
			param[2]=userinfo.getRelationship();
			
		}else{ param[2]=""; }
        
        if(userinfo.getSex()!=null){
			
			param[3]=userinfo.getSex();
			
		}else{ param[3]=""; }
        
        if(userinfo.getIdno()!=null){
			
			param[4]=userinfo.getIdno();
			
		}else{ param[4]=""; }
        
        if(userinfo.getPhone()!=null){
			
			param[5]=userinfo.getPhone();
			
		}else{ param[5]=""; }
        
        if(userinfo.getMail()!=null){
			
			param[6]=userinfo.getMail();
			
		}else{ param[6]=""; }
        
        if(userinfo.getZcode()!=null){
			
			param[7]=userinfo.getZcode();
			
		}else{ param[7]=""; }
        
        if(userinfo.getJob()!=null){
			
			param[8]=userinfo.getJob();
			
		}else{ param[8]=""; }
        
        if(userinfo.getAddress()!=null){
			
			param[9]=userinfo.getAddress();
			
		}else{ param[9]=""; }

		if(userinfo.getComuser()!=null){

			param[10]=userinfo.getComuser();

		}else{ param[10]=""; }
		
		baseDAO.executeSql(Hql, param);	
	}
	
	public Userinfo findUserByKey(String id)  {

		String Hql = "from Userinfo u where u.username=?";

		List<Object> param = new ArrayList<Object>();

		param.add(id);

		List<Userinfo> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	public List<Userinfo> findUserById(String id)  {

		String Hql = "from Userinfo u where u.comuser=?";

		List<Object> param = new ArrayList<Object>();

		param.add(id);

		List<Userinfo> list = this.find(Hql ,param);

		if(list.size()>0)
			return list;
		else
			return null;
	}
	
	public void updateInfo(Userinfo userinfo)  {

		this.update(userinfo);
	}
	
	public void deleteInfo(Userinfo userinfo)  {

		this.delete(userinfo);
	}

}
