package action.update;

import action.AbstractJsonLogAction;

public class DeleteDBAdmin extends AbstractJsonLogAction {

	private String table;
	private String id;
	private String desc;
	
	public String execute() {
		return null;
	}
	
	
	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }
}
