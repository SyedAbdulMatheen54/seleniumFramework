package com.hybridFramework.helper;

import org.openqa.selenium.WebElement;

public class GenericHelper extends AssertionHelper{

	
	public String getElementText(WebElement element)
	{
		if(!ElementIsPresent(element))
			return null;
	
		return element.getText();		
	}
	
	//get text present in text field
	public String getInputText(WebElement element)
	{
		if(!ElementIsPresent(element))
			return null;
		return element.getAttribute("value");
	}
}
