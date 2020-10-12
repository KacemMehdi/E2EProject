package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By comit = By.name("commit");
	By forgetPassword = By.xpath("//*[@id='hero']/div/form/div[4]/a");

	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement comit()
	{
		return driver.findElement(comit);
	}
	
	public forgotPassword getFrgtPassword()
	{
		 driver.findElement(forgetPassword).click();
		return new forgotPassword(driver);
		 
	}
}
