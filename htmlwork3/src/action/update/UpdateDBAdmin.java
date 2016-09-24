package action.update;

import hib.ora.entity.Foodinfo;
import hib.service.FoodinfoService;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class UpdateDBAdmin extends AbstractJsonLogAction {

	private String table;
	private Integer id;
	private String desc;

	@Autowired
	private FoodinfoService foodinfoService;

	public String execute() {
		if (table == "foodinfo") {
			String hql = "update "+table+" set fooddesc='"+desc+"' where idfoodinfo="+id;
//			Foodinfo food = new Foodinfo();
//			food.setid(id);
//			food.setFooddesc(desc);
			foodinfoService.update(hql);
		}

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
