package action.query;

import action.AbstractJsonLogAction;

/**
 * Created by chenxk on 2016/3/10.
 */
public class QueryCustomerInfoAction extends AbstractJsonLogAction {

    private String customerId;
    private String identityType;
    private String identityNo;
    private String custType;
    private String custName;
    private String fundAcco;

    public String query(String customerId) {
        this.customerId = customerId;
        before();
     
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

    public String getCustomerId() {
        return customerId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public String getCustType() {
        return custType;
    }

    public String getCustName() {
        return custName;
    }

    public String getFundAcco() {
        return fundAcco;
    }

    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }
}
