package com.hybridFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.WaitHelper;
import com.hybridFramework.testBase.Confi;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@value,'Login now')]")
	WebDriver loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitHelper wait=new WaitHelper();
		wait.waitTillElementVisible(driver, new Confi().getExplicitWaitTime(), userName);
	}

	public void enterUserName()
	{
		userName.sendKeys("admin");
	}
}
