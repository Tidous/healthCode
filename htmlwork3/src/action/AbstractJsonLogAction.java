/**
 *
 */
package action;

import java.lang.reflect.Field;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author
 */
public abstract class AbstractJsonLogAction extends ActionSupport {
	public String retmsg;
	public String retcode;
	private StringBuilder logBuilder = new StringBuilder();

	public abstract String getRetmsg();

	public abstract String getRetcode();

	public void before() {
		System.out.println("开始调用：" + this.getClass().getCanonicalName() + ":"
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
		logBuilder.append("\nbefore ").append(Thread.currentThread().getStackTrace()[2].getMethodName())
				.append(":");
		appendAllField();
	}

	private void appendAllField() {
		for (Field field : this.getClass().getDeclaredFields()) {
			try {
				// 排除依赖注入的service 和serialVersionUID
				if (field.getName().toLowerCase().indexOf("service") >= 0
						|| field.getName().indexOf("serialVersionUID") >= 0) {
					continue;
				}
				field.setAccessible(true);
				if(field.getName().toLowerCase().indexOf("password")>=0){
					logBuilder.append(field.getName()).append("=").append("不记录").append(" ");
				}else{
					logBuilder.append(field.getName()).append("=").append(field.get(this)).append(" ");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logBuilder.append(" retcode="+retcode+" retmsg="+retmsg);
	}

	public void after() {
		System.out.println("结束调用：" + this.getClass().getCanonicalName() + ":"
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
		logBuilder.append("\nafter ").append(Thread.currentThread().getStackTrace()[2].getMethodName())
				.append(":");
		appendAllField();
	}

	public <E> void logListInfo(String name, java.util.List<E> list) {

		System.out.println("正在调用：" + this.getClass().getCanonicalName() + ":"
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
		logBuilder.append("\ninner ").append(Thread.currentThread().getStackTrace()[2].getMethodName())
				.append(" " + name + ":");

		if (list == null || list.size() == 0) {
			logBuilder.append("null");
		} else {
			logBuilder.append(JSONArray.fromObject(list).toString());
		}

	}

	public void logOther(String info) {
		System.out.println("正在调用：" + this.getClass().getCanonicalName() + ":"
				+ Thread.currentThread().getStackTrace()[2].getMethodName());

		Logger logger = Logger.getLogger(this.getClass());
		StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("\ninner ").append(Thread.currentThread().getStackTrace()[2].getMethodName())
				.append(" ");
		logBuilder.append(info);
	}

	public void print() {
		Logger logger = Logger.getLogger(this.getClass());
		logger.info(this.logBuilder.append("\n").toString());
	}

	/**
	 * 添加CORS跨域支持。
	 */
	public static void addCorsSupport() {
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");

	}
}
