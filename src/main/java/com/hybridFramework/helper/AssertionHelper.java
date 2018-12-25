package com.hybridFramework.helper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.hybridFramework.testBase.TestBase;


public class AssertionHelper extends TestBase {
	
	public boolean ElementIsPresent(WebElement element)
	{
		boolean displayed=false;
		L_Logger.info("Checking element state");
		try
		{
			//set value as true if element is true 
			displayed= element.isDisplayed();
		}
		catch(Exception e)
		{
			//this block will be executed only when element is not present 
			L_Logger.info(element+" is not present");
		}
		return displayed;
		
	}
	
	public boolean elementIsNotPresent(WebElement element)
	{
		boolean flag=false;
		try
		{
			//If element is found then we will keep flag as false only
			element.isDisplayed();
		}
		catch(Exception e)
		{
			//If element is not found we will set flag as true
			flag=true;
		}
		return flag;
	}
	
	public boolean checkElementText(WebElement element,String text)
	{
		boolean flag=false;
		if(element.getText().equals(text))
		{
			flag=true;
		}
		return flag;
	}
}
