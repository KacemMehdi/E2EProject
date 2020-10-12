package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {

	public WebDriver driver;

	public forgotPassword (WebDriver driver) 
	{
		
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	By sendMe = By.name("commit");
	
	public WebElement EmailForgot() {
		
		return driver.findElement(email);
	}
	
	public WebElement SendMe() {
		
		return driver.findElement(sendMe);
	}
}
