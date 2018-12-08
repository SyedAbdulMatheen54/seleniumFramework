package com.hybridFramework.HomePage;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFramework.testBase.TestBase;

public class TestDataDriven extends TestBase{
	
	//Data Driver Test
	@DataProvider(name="loginData")
	public Object[][] dataP() throws IOException
	{
		
		return getExcelData("Credentials.xlsx", "login");
	}
	
	@Test(dataProvider="loginData")
	public void login(String username,String password)
	{
		L_Logger.info("Login user");
		System.out.println("User Name:- "+username);
		System.out.println("Password :- "+password);
	}
	

}
