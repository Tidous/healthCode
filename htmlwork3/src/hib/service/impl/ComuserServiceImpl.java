package hib.service.impl;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Comuser;
import hib.service.ComuserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ComuserService")
public class ComuserServiceImpl implements ComuserService {
	@Autowired
	BaseDAO<Comuser> baseDAO;

	@Override
	public void update(String hql, List<Object> param) {
		
		baseDAO.update(hql,param);
		
	}
	
	@Override
	public List<Comuser> find(String hql, List<Object> param) {
		
		return baseDAO.find(hql,param);
		
	}

	
	@Override
	public List<Comuser> find(String hql) {

		return baseDAO.find(hql);
	}
	
	@Override
	public void update(Comuser sysUser) {
		
		baseDAO.update(sysUser);		
		
	}
	
	@Override
	public void save(Comuser sysUser){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		java.util.Date sysdate=new java.util.Date();
		Timestamp tt=new Timestamp(sysdate.getTime());
		String date = df.format(tt);
		
		
		String Hql = "insert into health.comuser(" +
				"uid," +
				"username," +
				"email," +
				"mobilephone," +
				"password," +
				"createtime," +
				"lastlogintime," +
				"starttime," +
				"endtime," +
				"bufferedcase," + 
				"relateduser," + 
				"ismasteruser," + 
				"column6" + ") values(" +
					"?,"+
					"?,"+
					"?,"+
					"?,"+
					"?,"+
					"STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s'),"+
					"STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s'),"+
					"STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s'),"+
					"STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s'),"+
					"?,"+
					"?,"+
					"?,"+
					"STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s')"+")";
		
		Object[] param = new Object[13];
		
		if(sysUser.getUid()!=null){
			
			param[0]=sysUser.getUid();
			
		}else{ param[0]=000000; }
		
		if(sysUser.getUsername()!=null){
			
			param[1]=sysUser.getUsername();
			
		}else{ param[1]=""; }
		
		if(sysUser.getEmail()!=null){
			param[2]=sysUser.getEmail();
		}else{ param[2]=""; }
		
		if(sysUser.getMobilephone()!=null){
			param[3]=sysUser.getMobilephone();
		}else{ param[3]=""; }
		
		if(sysUser.getPassword()!=null){
			param[4]=sysUser.getPassword();
		}else{ param[4]=""; }
		
		if(sysUser.getCreatetime()!=null){
			param[5]=sysUser.getCreatetime();
		}else{ param[5]=date; }
		
		if(sysUser.getLastlogintime()!=null){
			param[6]=sysUser.getLastlogintime();
		}else{ param[6]=date; }
		
		if(sysUser.getStarttime()!=null){
			param[7]=sysUser.getStarttime();
		}else{  param[7]=date; }
		
		if(sysUser.getEndtime()!=null){
			param[8]=sysUser.getEndtime();
		}else{  param[8]=date; }
		
		if(sysUser.getBufferedcase()!=null){
			param[9]=sysUser.getBufferedcase();
		}else{  param[9]=""; }
		
		if(sysUser.getRelateduser()!=null){
			param[10]=sysUser.getRelateduser();
		}else{  param[10]=""; }
		
		if(sysUser.getIsmasteruser()!=null){
			param[10]=sysUser.getIsmasteruser();
		}else{  param[11]=0; }
		
		if(sysUser.getColumn6()!=null){
			param[10]=sysUser.getColumn6();
		}else{  param[12]=date; }
		
		baseDAO.executeSql(Hql, param);
		
	}

	
	public int getMaxUserId() {
		
		int id = 0;
		
		String Hql = "from Comuser c order by c.uid desc";

		List<Comuser> sysUserList = this.find(Hql);
		
		if(sysUserList.size()>0) {
			id = sysUserList.get(0).getUid();
		}
		return id;
	}


	public List<Comuser> findAllUser() {

		String Hql = "from Comuser";

		List<Comuser> comuserList = this.find(Hql);

		return comuserList;
	}
	
	public void updatePassword(Integer id, String password)  {

		String Hql = "update Comuser c set c.password=? where c.uid=?";

		List<Object> param = new ArrayList<Object>();

		param.add(password);

		param.add(id);

		this.update(Hql ,param);

	}


	public Comuser findUserByName(String user)  {

		String Hql = "from Comuser c where c.username=?";

		List<Object> param = new ArrayList<Object>();

		param.add(user);

		List<Comuser> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;

	}


	public Comuser findUserById(Integer id)  {

		String Hql = "from Comuser c where c.uid=?";

		List<Object> param = new ArrayList<Object>();

		param.add(id);

		List<Comuser> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;

	}
	
	public Comuser userLogin(String user, String password)  {

		String Hql = "from Comuser c where c.username=? and c.password=?";

		List<Object> param = new ArrayList<Object>();

		param.add(user);
		
		param.add(password);

		List<Comuser> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else{
			Hql = "from Comuser c where c.mobilephone=? and c.password=?";

			list = this.find(Hql ,param);

			if(list.size()>0)
				return list.get(0);
			else
				return null;
		}
	}

	public Comuser findUserByPhone(String phone)  {

		String Hql = "from Comuser c where c.mobilephone=?";

		List<Object> param = new ArrayList<Object>();

		param.add(phone);

		List<Comuser> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;

	}
	
	public Comuser checkuser(String user, String mobile)  {

		String Hql = "from Comuser c where c.username=? and c.mobilephone=?";

		List<Object> param = new ArrayList<Object>();

		param.add(user);
		
		param.add(mobile);

		List<Comuser> list = this.find(Hql ,param);

		if(list.size()>0)
			return list.get(0);
		else
			return null;

	}

}
