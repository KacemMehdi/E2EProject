package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//*[@id=\"content\"]/div/div/h2");
	private By navBar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	public LoginPage getLogin()
	{
		 driver.findElement(signin).click();
			LoginPage lop = new LoginPage(driver);
			return lop;
	}
	
	public WebElement getTitlePage()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	
	public WebElement getHeader() {
		
		return driver.findElement(header);
	}
	
	public List<WebElement> getNoThanksSize()
	{
		return driver.findElements(popup);
	}
	public WebElement getPopUp() 
	{
		return driver.findElement(popup);
	}
}
