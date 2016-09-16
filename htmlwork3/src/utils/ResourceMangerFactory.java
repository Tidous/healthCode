/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chenxk
 * 
 */
public class ResourceMangerFactory {
	private ArrayList resourceList;
	private HashMap resource;
	private String serverAddress;
	private int num;

	private ResourceMangerFactory() {
		resourceList = new ArrayList();

		serverAddress = PropertiesUtil.properties.getProperty("SERVER_ADDRESS");
		num = 1;
		this.addResource("htm/config.js", "config.js");
		this.addResource("htm/global.js", "global.js");
	}

	public static ResourceMangerFactory getInstance() {
		return new ResourceMangerFactory();
	}

	public ResourceMangerFactory addResource(String src, String dest) {
		this.addUrlResource(serverAddress  + src, dest);
		return this;
	}

	public ResourceMangerFactory addUrlResource(String url,String dest){
		resource = new HashMap<String, Object>();
		resource.put("num", num++);
		resource.put("source", url);
		resource.put("destination", dest);
		resourceList.add(resource);
		return this;
	}

	public ArrayList getResourceList() {
////		System.out.println(JSONObject.fromObject(this));
//		for(Object object:resourceList){
//			System.out.println(JSONObject.fromObject(object));
//		}
		return resourceList;
	}

}
