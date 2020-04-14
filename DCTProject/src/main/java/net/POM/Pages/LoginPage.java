package net.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
//	By emailField = By.xpath("//input[@id='i0116']");
	// by doing this way we do identifying and locating in one shot
	@FindBy(xpath="//input[@id='i0116']") WebElement emailAddress;
	@FindBy(xpath="//input[@id='idSIButton9']") WebElement nextBtn;
	@FindBy(xpath="//input[@name='passwd']") WebElement passwordField;
	@FindBy(xpath="//input[@type='submit']") WebElement signInBtn;
	@FindBy(xpath="//input[@id='idSIButton9']") WebElement stayYesBtn;
	
	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);	// must be done when using @FindBy notation
	}

	public void setEmail(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickSignIn() {
		signInBtn.click();
	}
	
	public void clickStayYes() {
		stayYesBtn.click();
	}
	
}
