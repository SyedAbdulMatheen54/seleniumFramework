package com.hybridFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.testBase.TestBase;

public class HomePage extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Logout']")
	public WebElement logout;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
