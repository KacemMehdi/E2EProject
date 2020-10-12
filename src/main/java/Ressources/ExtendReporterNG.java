package Ressources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	
	static ExtentReports extentReport;

	public static ExtentReports getReportObject() 
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reportSpark = new ExtentSparkReporter(path);
		reportSpark.config().setReportName("Web Automation Results");
		reportSpark.config().setDocumentTitle("Mehdi Tests Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reportSpark);
		extentReport.setSystemInfo("QA Automation","Mehdi");	
		
		return extentReport ;
	}

}
