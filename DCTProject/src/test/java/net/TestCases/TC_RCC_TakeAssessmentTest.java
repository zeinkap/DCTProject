package net.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.POM.Pages.RccLaunchAssessment;
import resources.Base;

public class TC_RCC_TakeAssessmentTest extends Base {
@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("rccUrl"));
	}
	
	@Test
	public void takeTest() throws InterruptedException {
		RccLaunchAssessment rcc = new RccLaunchAssessment(driver);
		rcc.getUsername().sendKeys(prop.getProperty("rccUsername"));
		rcc.clickSignInBtn().click();
		rcc.getPassword().sendKeys(prop.getProperty("rccPw"));
		rcc.clickSignInBtn().click();
		rcc.clickStudy().click();
		rcc.clickSubjectMenu().click();
		rcc.clickSubjectNumber().click();
		Thread.sleep(1000);
		rcc.clickVisit().click();
		rcc.clickBeginBattery().click();
		//rcc.clickUncheckCompleteBox().click();
		rcc.clickBeginAssessBtn().click();
		
		
		 List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		 System.out.println("Number of frames in a page :" + ele.size());
		 for(WebElement el : ele){
		      //Returns the Id of a frame.
		        System.out.println("Frame Id :" + el.getAttribute("id"));
		      //Returns the Name of a frame.
		        System.out.println("Frame name :" + el.getAttribute("name"));
		 }
		 
		driver.switchTo().frame("gwt");
		Thread.sleep(3000);
		rcc.clickConfirmBtnYes().click();
		driver.switchTo().defaultContent();
		
	}
	
	
}
