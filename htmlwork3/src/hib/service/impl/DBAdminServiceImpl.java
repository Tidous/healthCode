package hib.service.impl;

import hib.ora.dao.BaseDAO;
import hib.service.DBAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DBAdminService")
public class DBAdminServiceImpl implements DBAdminService {

	@Autowired
	BaseDAO<String> baseDAO;
	
    public List<String> findSql(String table, String pageno, String pagesize) {
		
		String sql = "select * from health."+table+" limit "+pageno+","+pagesize+"";

		List<String> result = baseDAO.findSql(sql);
		return result;
	}
}
