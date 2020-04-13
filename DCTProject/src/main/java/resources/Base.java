package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.POM.Pages.HomePage;
import net.POM.Pages.LoginPage;

public class Base {
	public static WebDriver driver;	
	public WebDriverWait wait;
	public Properties prop;
	
	
	// resuable browser driver method 
	public WebDriver initializeDriver() throws IOException {
		String chroPath = "C:\\Users\\zkapadia\\Documents\\Selenium_jars\\chromedriver.exe";
		String firePath = "C:\\Users\\zkapadia\\Documents\\Selenium_jars\\geckodriver.exe";
		String iePath = "C:\\Users\\zkapadia\\Documents\\Selenium_jars\\IEDriverServer.exe";
		
		prop = new Properties();
		
		FileInputStream fls = new FileInputStream("C:\\Users\\zkapadia\\eclipse-workspace\\DCTProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fls);
		
		String browserType = prop.getProperty("browserType");
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chroPath);
			//to handle SSL certificates
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			//options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--dns-prefetch-disable");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.setCapability("capability_name", "capability_value");
			driver = new ChromeDriver(options);		
		} 
		else if (browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firePath);
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.setCapability("capability_name", "capability_value");
			driver = new FirefoxDriver(ffoptions);
		} 
		else if (browserType.equals("ie")) {
			System.setProperty("webdriver.ie.driver", iePath);
			driver = new InternetExplorerDriver();
		} 
		else {
			System.out.println("Entered incorrect browser.");
			driver.close();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	// this will apply to all test cases
		driver.manage().window().maximize();
		
		return driver;
	}
	
	// Logging into DCT application 
	public void dctLogin() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.setEmail(prop.getProperty("email"));
		//Thread.sleep(1000);
		login.clickNext();
		//Thread.sleep(1000);
		login.setPassword(prop.getProperty("password"));
		Thread.sleep(1000);
		login.clickSignIn();
		Thread.sleep(1000);
		login.clickStayYes();
	}
	
	// moving assessment via assessment finder
	public void moveAssessment() throws InterruptedException {
		HomePage move = new HomePage(driver);
		move.setStudy(prop.getProperty("study"));
		move.setSubject(prop.getProperty("sourceSubject"));
		move.setVisit(prop.getProperty("sourceVisit"));
		Thread.sleep(1000);
		move.clickFindByCriteriaBtn();
		move.selectAssessment();
		Thread.sleep(1000);
		move.clickMoveBtn();
		System.out.println("Successfully clicked move!");
		
		//destination dialog opens
		move.setDestinationSubject(prop.getProperty("destSubject"));
		move.setDestinationVisit(prop.getProperty("destVisit"));
		move.clickOkBtn();
		move.clickGoBackBtn();
		move.clickCancelBtn();
		//moveAssess.clickConfirmBtn();
		System.out.println("Move initiated for Source Subject: " + prop.getProperty("sourceSubject") + ", Visit: " + prop.getProperty("sourceVisit") +
				"\nto Destination Subject: " + prop.getProperty("destinationSubject") + ", Visit: " + prop.getProperty("destinationVisit"));
	} 
	
	// moving assessment via test Identifier
//	public void moveAssessment2() throws InterruptedException {
//		AssessmentFinderSearch move2 = new AssessmentFinderSearch(driver);
//		move2.getAssessmentIdInput().sendKeys(prop.getProperty("testId"), Keys.TAB);
//		Thread.sleep(2000);
//		move2.clickFindByAssessmentIdBtn().click();
//		move2.selectAssessment().click();
//		System.out.println("The Test Id of source assessment is: " + move2.getAssessmentIdText());
//		move2.clickMoveBtn().click();
//		System.out.println("Successfully clicked move button!");
//		Thread.sleep(3000);
//		move2.getDestinationSubject().sendKeys(prop.getProperty("destinationSubject"));
//		System.out.println("Entered in dest sub");
//		move2.getDestinationVisit().sendKeys(prop.getProperty("destinationVisit"));
//		System.out.println("Entered in dest visit");
//		Thread.sleep(2000);
//		move2.clickOkBtn().click();
//		Thread.sleep(2000);
//		System.out.println("Clicked Ok btn");
//		move2.clickGoBackBtn().click();
//		Thread.sleep(2000);
//		System.out.println("Clicked Go Back btn");
//		move2.clickCancelBtn().click();
//		//moveAssess.clickConfirmBtn().click();
//		System.out.println("Move initiated. Source Subject: " + prop.getProperty("sourceSubject") + ", Source Visit: " + prop.getProperty("sourceVisit") +
//				"\nDestination Subject: " + prop.getProperty("destSubject") + ", Destination VIsit: " + prop.getProperty("destVisit"));
//	}
	
	// taking screenshots for test failures
//	public void getScreenshot(String result) throws IOException {
//		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
//		// to bring screenshot to our desktop
//		FileUtils.copyFile(src, new File("C:\\Users\\zkapadia\\Pictures\\sele-screenshots\\" + result + "Screenshot.png"));
//	}
	
}
