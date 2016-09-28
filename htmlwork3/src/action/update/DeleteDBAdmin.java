package action.update;

import hib.ora.entity.Foodinfo;
import hib.service.BirthdateService;
import hib.service.CasetableService;
import hib.service.ComuserService;
import hib.service.FoodinfoService;
import hib.service.UseradvService;
import hib.service.UserhabitService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class DeleteDBAdmin extends AbstractJsonLogAction {

	private String table;
	private Integer id;
	private String desc;
	
	@Autowired
	private FoodinfoService foodinfoService;
	private UseradvService useradvService;
	private BirthdateService birthdateService;
	private CasetableService casetableService;
	private ComuserService comuserService;
	private UserhabitService userhabitService;


	public String execute() {
        before();
		if (table == "foodinfo") {
			Foodinfo food = new Foodinfo();
			food.setid(id);
			food.setFooddesc(desc);
			if (foodinfoService != null) {
				foodinfoService.delete(food);	
			}
		}

//		if (table == "casetable") {
//			String hql = "update "+table+" set fooddesc='"+desc+"' where idfoodinfo="+id;
//			casetableService.update(hql);
//		}
//
//		if (table == "comuser") {
//			String hql = "update "+table+" set fooddesc='"+desc+"' where idfoodinfo="+id;
//			comuserService.update(hql);
//		}
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


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
