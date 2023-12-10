package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop;
	
	public static String getConfig(String key) throws Exception {
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Config/ApplicationConfiguration.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}

}
