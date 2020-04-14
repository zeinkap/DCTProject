package net.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import net.POM.Pages.LoginPage;
import resources.Base;

public class TC_DCT_MakePrimaryTest extends Base {
	//Logger log = LogManager.getLogger(TC_DCT_MakePrimaryTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("baseUrl"));
		//dctLogin();
	}
	
	
	
	
	
}
