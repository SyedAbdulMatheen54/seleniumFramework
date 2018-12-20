package com.hybridFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.WaitHelper;
import com.hybridFramework.testBase.Confi;
import com.hybridFramework.testBase.TestBase;

public class LoginPage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="pwd")
	WebElement passwordobj;
	
	@FindBy(xpath="//input[contains(@value,'Login now')]")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitHelper wait=new WaitHelper();
		wait.waitTillElementVisible(driver, new Confi().getExplicitWaitTime(), userName);
	}

	public void enterUserName(String username)
	{
		userName.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		passwordobj.sendKeys(password);
	}
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	public void loginToActi(String username, String password)
	{
		enterUserName(username);
		enterPassword(password);
		clickOnLogin();
		
	}
}
