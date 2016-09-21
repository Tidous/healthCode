package hib.service;

import java.util.List;

public interface DBAdminService {
	
	public List<String> findSql(String table, String pageno, String pagesize);
}
