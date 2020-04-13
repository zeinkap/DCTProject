package net.POM.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='react-select-2-input']") WebElement study;
	@FindBy(xpath="//input[@id='react-select-3-input']") WebElement sourceSubject;
	@FindBy(xpath="//input[@id='react-select-4-input']") WebElement sourceVisit;
	@FindBy(xpath="//input[@id='showInvalidatedSwitch']") WebElement invalidatedSwitch;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]") WebElement findByCriteriaBtn;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]") WebElement selectAssessment;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]") WebElement testId;
	@FindBy(xpath="//button[@id='action-row-move-button']") WebElement moveBtn;
	
	// move assessment dialog
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]") WebElement destinationSubject;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]") WebElement destinationVisit;
	@FindBy(xpath="//button[@id='move-selection-button-prev']") WebElement cancelBtn;
	@FindBy(xpath="//button[@id='move-selection-button-next']") WebElement okBtn;
	@FindBy(xpath="//button[@id='move-confirmation-button-prev']") WebElement goBackBtn;
	@FindBy(xpath="//button[@id='move-confirmation-button-next']") WebElement confirmBtn;
	
	// searching by assessment Id
	@FindBy(xpath="//input[@id='findByAssessmentId']") WebElement assessmentId;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]") WebElement findByAssessmentIdBtn;
	
	public HomePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}
	
	public void setStudy(String studyName) {
		study.sendKeys(studyName, Keys.ENTER);
	}
	
	public void setSubject(String subjectName) {
		sourceSubject.sendKeys(subjectName, Keys.ENTER);
	}
	
	public void setVisit(String visitName) {
		sourceVisit.sendKeys(visitName, Keys.ENTER);
	}
	
	public void setInvalidatedSwitch() {
		invalidatedSwitch.click();
	}
	
	public void clickFindByCriteriaBtn() {
		findByCriteriaBtn.click();
	}
	
	public void selectAssessment() {
		selectAssessment.click();
	}
	
	public void getAssessmentIdText() {
		testId.getText();
	}
	
	public void clickMoveBtn() {
		moveBtn.click();
	}
	
	public void setDestinationSubject(String subjectName) {
		destinationSubject.sendKeys(subjectName, Keys.ENTER);
	}
	
	public void setDestinationVisit(String visitName) {
		destinationVisit.sendKeys(visitName, Keys.ENTER);
	}
	
	public void clickCancelBtn() {
		cancelBtn.click();
	}
	
	public void clickOkBtn() {
		okBtn.click();
	}
	
	public void clickGoBackBtn() {
		goBackBtn.click();
	}
	
	public void clickConfirmBtn() {
		confirmBtn.click();
	}
	
	// searching by assessment Id
	public void getAssessmentIdInput() {
		assessmentId.click();
	}
	
	public void clickFindByAssessmentIdBtn() {
		findByAssessmentIdBtn.click();
	}
	
}
