package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Ressources.Base;
import pageObjects.LandingPage;



public class ValidateNavBar extends Base {
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialise() throws IOException {
		this.driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException 
	{
		
		LandingPage lap = new LandingPage(driver);
		Assert.assertTrue(lap.getNavBar().isDisplayed());
		log.info("Navigation Barre is Displayed"); 
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
