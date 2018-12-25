package com.hybridFramework.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	WebDriver driver;
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Execute script when only script is passed
	public void executeScript(String script)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
	}
	
	//Execute script when only script and arguments is passed
	public void executeScript(String script,Object... args)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(script,args);
		}
		
	//Scroll page by pixcel
	public void ScrollByPixcel()
	{
		//Scroll page till 1000 pixcel
		executeScript("window.scrollBy(0,1000)");
	}
	
	//public scroll till element is visible
	public void scrollTillElement(WebElement element)
	{
		executeScript("argument[0].scrollIntoView()", element);
	}
	
	//Scroll page vertically down
	public void scrollDownVertically()
	{
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//Scroll page vertically up
		public void scrollUpVertically()
		{
			executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		}
}
