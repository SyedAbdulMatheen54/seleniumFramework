package com.hybridFramework.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	private WebDriver driver;
	
	//Initialize webdriver
	public AlertHelper(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//This method will acts as a wrapper method
	public Alert getAlert()
	{
		return driver.switchTo().alert();
	}
	//accept alert
	public void acceptAlert()
	{
		getAlert().accept();
	}
	//Dismiss Alert
	public void dismissAlert()
	{
		getAlert().dismiss();
	}
	
	public String getAlertText()
	{
		return getAlert().getText();
	}
	
	public void sendKeysInAlert(String key)
	{
		getAlert().sendKeys(key);
	}
	
	//customize constructor to check Alert is present or not
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public void acceptAlertIfPresent()
	{
		if(!alertIsPresent())
			return;
		acceptAlert();
	}
	
	//Send key in alert and accept alert
	public void sendKeyIfAlertPresent(String val)
	{
		if(!alertIsPresent())
			return;
		sendKeysInAlert(val);
		acceptAlert();
	}
	
}
