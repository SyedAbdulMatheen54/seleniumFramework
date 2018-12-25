package com.hybridFramework.Login;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.hybridFramework.PageObject.HomePage;
import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.helper.AssertionHelper;
import com.hybridFramework.testBase.Confi;
import com.hybridFramework.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase{
	
	@Test
	public void login() throws IOException
	{
		Confi config=new Confi();
		driver.get(config.getUrl());
		LoginPage login=new LoginPage(driver);
		login.loginToActi(pro.getProperty("actiValidUserName"),pro.getProperty("actiValidPass"));
		
		//Verifying login is successfull
		HomePage home=new HomePage(driver);
		AssertionHelper assertHelp=new AssertionHelper();
		boolean loginStatus = assertHelp.ElementIsPresent(home.logout);
		if (loginStatus)
		{
			assertTrue(true, "Login was succesfull");
			//logger.log(LogStatus.PASS, "Login was succesfull");
		}
		else	
		{
			Assert.fail("Login was not succesfull");
			//logger.log(LogStatus.FAIL, "Login was not succesfull");
		}
	}
}
