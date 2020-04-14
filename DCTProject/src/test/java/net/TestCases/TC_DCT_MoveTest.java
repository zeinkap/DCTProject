package net.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.POM.Pages.HomePage;
import net.POM.Pages.LoginPage;
import resources.Base;

@SuppressWarnings("deprecation")
public class TC_DCT_MoveTest extends Base {
	
	static {
		initLogger();
	}
	
	// create log instance
	Logger log = Logger.getLogger(TC_DCT_MoveTest.class);

	public static void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	ExtentTest test;		// what details should be populated in the report
	ExtentReports extent;	// specify location of report
	ExtentHtmlReporter htmlReporter;	// type of report to use
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("baseURL"));
		log.info("Successfuly connected to base url");
	}
	
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyExtentReport.html");
		// create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
    	extent.setSystemInfo("Environment", "Testing");
    	extent.setSystemInfo("User Name", "zkapadia");
    	htmlReporter.config().setDocumentTitle("Extent HTML Report for DCTProject"); 
        // Name of the report
    	htmlReporter.config().setReportName("Extent HTML Report for TC_DCT_MoveTest"); 
        // Dark Theme
    	htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Test
	public void loginToDCT() throws InterruptedException {
		test = extent.createTest("Verify logging into DCT application");
		dctLogin();
		Assert.assertEquals(driver.getTitle(), "Data Cleaning Tool");
		log.info("Successfully logged into DCT");
	}

	@Test
	public void moveByAssessmentFinder() throws InterruptedException {
		test = extent.createTest("Verify moving assessment by assessment finder");
		dctLogin();
		moveAssessment();
		log.info("Successfully moved assessment");
		//test.log(Status.PASS, "Assessment moved");
	}
	
//	@Test
//	public void moveByAssessmentId() throws InterruptedException {
//		test = extent.createTest("Verify moving assessment by Assessment ID");
//		dctLogin();
//		moveAssessment2();
//		log.info("Successfully moved assessment");
//	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "test.addScreenCapture" method. 
			//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(result.getName());
			//To add it in the extent report 
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		driver.quit();
		log.info("Closed all browser windows");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();	// to write/update logs to file
		//driver=null;	// to clear objects from heap memory and reduce memory storage
	}
	
}
