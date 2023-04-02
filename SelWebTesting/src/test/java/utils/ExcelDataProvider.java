package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData() {
		String excelPath = System.getProperty("user.dir")+"/excel/Data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
		
	}
	@Test(dataProvider = "loginData")
	public void test(String un, String pw) throws InterruptedException {
		System.out.println(un+" | "+pw);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		Thread.sleep(3000);
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i =1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				String cellData = excel.getCellValue(i,j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}

}