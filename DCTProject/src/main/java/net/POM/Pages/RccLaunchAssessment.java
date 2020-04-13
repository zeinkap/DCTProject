package net.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RccLaunchAssessment {
	public WebDriver driver;
	
	By userNameSelect = By.xpath("//input[@id='login_username']");
	By passwordSelect = By.xpath("//input[@id='login_password']");
	By signInBtn = By.xpath("//button[@id='login_applyButton']");
	
	// after signed in to RCC
	By studySelect = By.xpath("//div[contains(text(),'zk dmt test')]");
	By subjectMenuSelect = By.xpath("//div[@id='leftMenuButtons_navSubjects']");
	By subjectNumberSelect = By.xpath("//div[contains(text(),'testtest')]");
	By visitSelect = By.xpath("//div[contains(text(),'Visit 1')]");
	By beginBattery = By.xpath("//div[@id='subjectMatrixByEventsViewAbstract_rowCrfName_beginCogstateBattery']");
	By uncheckCompleteBox = By.xpath("//i[@id='dataCollectionWidget_checkboxComplete']");
	By beginAssessBtn = By.xpath("//div[@class='dciInputPanel']//div//div//div//div//div//button[@type='button']");
	By confirmBtnYes = By.xpath("//button[@id='commonTools_buttonYes']");
	
	
	public RccLaunchAssessment(WebDriver driver2) {
		this.driver = driver2;
	}
	
	
	public WebElement getUsername() {
		return driver.findElement(userNameSelect);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passwordSelect);
	}
	
	public WebElement clickSignInBtn() {
		return driver.findElement(signInBtn);
	}
	
	public WebElement clickStudy() {
		return driver.findElement(studySelect);
	}
	
	public WebElement clickSubjectMenu() {
		return driver.findElement(subjectMenuSelect);
	}
	
	public WebElement clickSubjectNumber() {
		return driver.findElement(subjectNumberSelect);
	}
	
	public WebElement clickVisit() {
		return driver.findElement(visitSelect);
	}
	
	public WebElement clickBeginBattery() {
		return driver.findElement(beginBattery);
	}
	
	public WebElement clickUncheckCompleteBox() {
		return driver.findElement(uncheckCompleteBox);
	}
	
	public WebElement clickBeginAssessBtn() {
		return driver.findElement(beginAssessBtn);
	}
	
	public WebElement clickConfirmBtnYes() {
		return driver.findElement(confirmBtnYes);
	}
	
}
