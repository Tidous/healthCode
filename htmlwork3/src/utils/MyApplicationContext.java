package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {
	
	public static ApplicationContext context=null;
	
	public ApplicationContext getApplicationContext(){
		
		if(context ==null){
			
			context = new ClassPathXmlApplicationContext(  
					 "applicationContext.xml");
		}
		
		return context;
			
	}
	
}
