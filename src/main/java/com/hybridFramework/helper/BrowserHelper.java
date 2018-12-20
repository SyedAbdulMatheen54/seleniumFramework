package com.hybridFramework.helper;

import com.hybridFramework.testBase.TestBase;

public class BrowserHelper extends TestBase{

	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
}
