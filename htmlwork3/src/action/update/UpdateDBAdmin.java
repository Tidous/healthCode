package action.update;

import hib.ora.entity.Casetable;
import hib.ora.entity.Foodinfo;
import hib.service.*;

import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class UpdateDBAdmin extends AbstractJsonLogAction {

	//foodtable
	private String table;
	private Integer id;
	private String desc;
	
    //casetable
	private String mainid;
	private String subid;
	private String text;
	private String shortn;
	private String diet;
	private String engdesc;
	private String engdiet;
	

	@Autowired
	private FoodinfoService foodinfoService;
	
	@Autowired
	private UseradvService useradvService;
	
	@Autowired
	private BirthdateService birthdateService;
	
	@Autowired
	private CasetableService casetableService;
	
	@Autowired
	private ComuserService comuserService;
	
	@Autowired
	private UserhabitService userhabitService;


	public String execute() {
        before();

		try {
			if (table.equalsIgnoreCase("foodinfo")) {
				Foodinfo food = new Foodinfo();
				food.setid(id);
				food.setFooddesc(desc);
				if (foodinfoService != null) {
					foodinfoService.update(food);	
				}
			}
			if (table.equalsIgnoreCase("casetable")) {
				Casetable caset = new Casetable();
				caset.setMaincase(mainid);
				caset.setSubcase(subid);
				caset.setDescription(text);
				caset.setDiet(diet);
				caset.setEdescription(engdesc);
				caset.setEdiet(engdiet);
				caset.setIncrementallink(shortn);
				if (casetableService != null) {
					casetableService.update(caset);	
				}
			}
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

//		if (table == "comuser") {
//			String hql = "update "+table+" set fooddesc='"+desc+"' where idfoodinfo="+id;
//			comuserService.update(hql);
//		}
		
		retmsg = "1";
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

	public String getMainid() {
		return mainid;
	}

	public void setMainid(String mainid) {
		this.mainid = mainid;
	}

	public String getSubid() {
		return subid;
	}

	public void setSubid(String subid) {
		this.subid = subid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getShortn() {
		return shortn;
	}

	public void setShortn(String shortn) {
		this.shortn = shortn;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getEngdesc() {
		return engdesc;
	}

	public void setEngdesc(String engdesc) {
		this.engdesc = engdesc;
	}

	public String getEngdiet() {
		return engdiet;
	}

	public void setEngdiet(String engdiet) {
		this.engdiet = engdiet;
	}
}
