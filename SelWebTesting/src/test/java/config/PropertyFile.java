package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import tests.GoogleSearchTest;

public class PropertyFile {

	public static Properties prop = new Properties();
	

	public static void main(String[] args) {
		getProperties();
		setProperties();
	}
	public static void getProperties() {

		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.Properties");
			prop.load(fis);
			GoogleSearchTest.browser= prop.getProperty("browser");
			GoogleSearchTest.textbox_search= prop.getProperty("textbox_search");
			GoogleSearchTest.searchText= prop.getProperty("searchText");
			GoogleSearchTest.button_search= prop.getProperty("button_search");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void setProperties() {
		try {
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.Properties");
			//prop.setProperty("result", "PASS");
			prop.store(fos, null);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}



}

