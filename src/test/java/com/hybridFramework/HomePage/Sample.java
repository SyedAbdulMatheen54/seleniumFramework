package com.hybridFramework.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.hybridFramework.util.ResourceHelper;

public class Sample extends ResourceHelper{

	@Test
	public void sampleMethod()
	{
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://abdul:82/login.do");
		try
		{
			driver.switchTo().alert();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		driver.close();*/
		int i=10;
		String s;
		s=String.valueOf(i);
	}
	
}
