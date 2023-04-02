package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearch;

public class GoogleSearchTest {
	
	static WebDriver driver;
	public static String browser;
	public static String textbox_search;
	public static String button_search;
	public static String searchText;
	
	
	@BeforeTest
	public void setUpTest() {
		
		PropertyFile.getProperties();
		if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
	}
	
	@	Test
	public static void googleSearchTest() {
		
		GoogleSearch searchPageObj = new GoogleSearch(driver);
		driver.get("http://google.com");
		searchPageObj.setTextInSearchBox(textbox_search,searchText);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchPageObj.clickSearchButton(button_search);
	}
	
	@AfterTest
	public void tearDownTest() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		System.out.println("Test executed successfully");
		PropertyFile.setProperties();
	}

}