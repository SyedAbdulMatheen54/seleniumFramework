package com.hybridFramework.testBase;

public class Confi extends TestBase
{
	public int getExplicitWaitTime()
	{
		return Integer.parseInt(pro.getProperty("explicitWait"));
	}
	
	public int getImplicitWaitTime()
	{
		return Integer.parseInt(pro.getProperty("implicitWait"));
	}
	
	public String getBrowserName()
	{
		return pro.getProperty("browser");
	}
	
	public String getUrl()
	{
		return pro.getProperty("url");
	}
}
