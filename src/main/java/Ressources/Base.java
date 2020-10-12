package Ressources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ressources\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		// mvn test -Dbrowser = chrome, firefox, ie ... from maven
		//String browserName =System.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.contains("chrome"))
		{
			//execute in chrome
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
		}
		
		else if (browserName.equals("firefox"))
		{
			//execute in firefox
			 
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			//execute in IE
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");
			//WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		return driver;
	}
	
	public String GetScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	
	}

}
