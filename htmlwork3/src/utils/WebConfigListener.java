package utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebConfigListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent arg0) {

		PropertiesUtil.properties = new Properties();
		try {
			String path = (getClass().getClassLoader().getResource("").toURI())
					.getPath();
			FileInputStream fis = new FileInputStream(path + "conf.properties");
			PropertiesUtil.properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
}
