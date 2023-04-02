package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
	
	WebDriver driver;
	
	public GoogleSearch(WebDriver driver){
		this.driver= driver;		
	}
	
	public void setTextInSearchBox(String textbox_search, String text) {
		driver.findElement(By.name(textbox_search)).sendKeys(text);
	}
	
	public void clickSearchButton(String button_search) {
		driver.findElement(By.name(button_search)).sendKeys(Keys.RETURN);
	}

}