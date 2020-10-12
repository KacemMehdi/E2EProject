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

public class ValidateTitle extends Base {

	public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	LandingPage lap;
	
	@BeforeTest
	public void initialise() throws IOException {
		
		this.driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Home Page");
	}
	@Test
	public void validatePageTitle() throws IOException 
	{
		lap = new LandingPage(driver);
		Assert.assertEquals(lap.getTitlePage().getText(),"FEATURED 123 COURSES");
		log.info("Successfuly validate Text Message");

	}
	@Test
	public void validatePagexHeader() throws IOException 
	{
		Assert.assertEquals(lap.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfuly validate Text Header");
		
	
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
