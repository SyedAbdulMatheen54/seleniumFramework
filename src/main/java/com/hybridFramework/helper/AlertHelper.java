package com.hybridFramework.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	
	Alert alert;
	public void switchToAlert(WebDriver driver)
	{	
		try
		{
			alert=driver.switchTo().alert();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public void sendKeyToAlert(String data)
	{
		try
		{
			alert.sendKeys(data);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void dismissAlert()
	{
		try
		{
			alert.dismiss();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void acceptAlert()
	{
		try
		{
			alert.dismiss();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
}
