package net.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RCCCreateStudy {
public WebDriver driver;
	
	//sign into RCC
	By userNameSelect = By.xpath("//input[@id='login_username']");
	By passwordSelect = By.xpath("//input[@id='login_password']");
	By signInBtn = By.xpath("//button[@id='login_applyButton']");
	
	
}
