package com.hybridFramework.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.testBase.TestBase;

public class LoginTest extends TestBase{
	WebDriver driver;
	@Test
	public void login() throws IOException
	{
		driver=getBrowser("chrome");
		loadProportiesFile();
		driver.get(TestBase.pro.getProperty("url"));
		LoginPage loginPageObj=new LoginPage(driver);
		loginPageObj.enterUserName();
		driver.close();
		System.out.println("Done");
	}
}
