package com.hybridFramework.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.testBase.Confi;
import com.hybridFramework.testBase.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void login() throws IOException
	{
		Confi config=new Confi();
		driver.get(config.getUrl());
		LoginPage login=new LoginPage(driver);
		login.loginToActi(pro.getProperty("actiValidUserName"),pro.getProperty("actiValidPass"));
	}
}
