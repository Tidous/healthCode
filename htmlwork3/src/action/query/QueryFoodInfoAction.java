package action.query;

import hib.ora.entity.Foodinfo;
import hib.service.FoodinfoService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import action.AbstractJsonLogAction;

public class QueryFoodInfoAction extends AbstractJsonLogAction {

    private Integer id;
    private String fooddesc;
    
    @Autowired
	private FoodinfoService foodinfoService;
    
    public String query() {
		before();
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		// 获取页码参数，默认为0

		if (foodinfoService != null) {
			Foodinfo food = new Foodinfo();
			food = foodinfoService.findFoodById(id);
			if (food != null) {
				this.retmsg = "success";
				this.fooddesc = food.getFooddesc();
			}
			else {
				this.retmsg = "fail";
			}
		}
		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFooddesc() {
		return fooddesc;
	}

	public void setFooddesc(String fooddesc) {
		this.fooddesc = fooddesc;
	}
}
