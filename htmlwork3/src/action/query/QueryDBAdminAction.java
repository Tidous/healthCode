package action.query;

import java.util.List;

import hib.service.DBAdminService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class QueryDBAdminAction extends AbstractJsonLogAction {

	private String table;
	private String pageno;
	private String pagesize;
	
	@Autowired
	private DBAdminService dbAdminService;

	private List result;
	
	public String query() {
        before();
        
        result = dbAdminService.findSql(table, pageno, pagesize);
     
        after();
        print();

        return SUCCESS;
    }
	
	
	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }


	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}


	public String getPageno() {
		return pageno;
	}


	public void setPageno(String pageno) {
		this.pageno = pageno;
	}


	public String getPagesize() {
		return pagesize;
	}


	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}


	public List getResult() {
		return result;
	}
}
