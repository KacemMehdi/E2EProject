package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ressources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.forgotPassword;

public class HomePage extends Base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialise() throws IOException {
		this.driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage lap = new LandingPage(driver);
		
		LoginPage lop = lap.getLogin();
		lop.email().sendKeys(userName);
		lop.password().sendKeys(password);
		log.info(text);
		lop.comit().click();
		forgotPassword fp = lop.getFrgtPassword();
		fp.EmailForgot().sendKeys("forgotemail@email.com");
		fp.SendMe().click();
	}

	@DataProvider
	public Object[][] getData() {
		//nb lignes = nb type de JDD
		//nb de colum = nb de JDD
		Object[][] data = new Object[2][3];
		
		data[0][0]="email@email.com";
		data[0][1]="123456";
		data[0][2]="Test JDD 1";
		
		data[1][0]="restructeduser@ase.com";
		data[1][1]="123456";
		data[1][2]="Test JDD 2";
		
		return data;
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
