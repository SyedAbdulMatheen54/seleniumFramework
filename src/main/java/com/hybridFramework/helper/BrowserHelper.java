package com.hybridFramework.helper;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {

	WebDriver driver;
	
	public BrowserHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void refreshBrowser()
	{
		driver.navigate().refresh();
	}
	
	//This method will get all windows
	public Set<String> getAllWindows()
	{
		return driver.getWindowHandles();
	}
	
	public void switchToWindow(int index)
	{
		//put all windows in linked list
		LinkedList<String> windowID=new LinkedList<String>(getAllWindows());
		//Switch to specfic window
		driver.switchTo().window(windowID.get(index));
	}
	
	public void switchToParentWindow()
	{
		LinkedList<String> windowID=new LinkedList<String>(getAllWindows());
		driver.switchTo().window(windowID.get(0));
	}
	
	//this method will close all child window and then switch control to parent window
	public void switchToParentByClosingChild()
	{
		LinkedList<String> windowID=new LinkedList<String>(getAllWindows());
		//Close all child windows, without closing parent(Since parent window is present at zero index)
		for(int i=1;i<windowID.size();i++)
		{
			driver.switchTo().window(windowID.get(i));
			driver.close();
		}
		
		//Switch to parentWindow
		switchToParentWindow();
	}
	
	//Switch to Frame by Name or FrameID
	public void switchToFrame(String frameIDOrName)
	{
		driver.switchTo().frame(frameIDOrName);
	}
	
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
}
