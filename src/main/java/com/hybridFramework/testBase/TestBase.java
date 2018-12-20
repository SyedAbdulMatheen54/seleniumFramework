package com.hybridFramework.testBase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybridFramework.ExcelReader.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	//Test base contains important method that will be used in multiple places framework
	public WebDriver driver;
	public static Properties pro;
	public File file;
	public FileInputStream fInput;
	public WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ITestResult result;
	public static final Logger L_Logger=Logger.getLogger(TestBase.class.getName());
	
	//In order to generate report we need to first create object of ExtentReports, 
	//Since this is static block, this block will be executed 1st before creating any object
		static
		{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
			String timeStamp=formatter.format(cal.getTime());
			extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/report/test"+timeStamp+".html",false);
			String Log_path="log4j.properties";
			//Here we will specifiy our Logger propery file
			PropertyConfigurator.configure(Log_path);
			TestBase test=new TestBase();
			try {
				test.loadProportiesFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Confi config=new Confi();
			//System.out.println("launch browser");
			//test.getBrowser(config.getBrowserName());
			System.out.println("static method");
		}
		
		@BeforeTest
		public void launchBrowser()
		{
			Confi config=new Confi();
			System.out.println("launch browser");
			getBrowser(config.getBrowserName());
		}
		
		@AfterTest(alwaysRun=true)
		public void closeBrowser()
		{
			driver.close();
		}
		
		//Before test method we need to start logging
		@BeforeMethod
		public void startReport(Method MethodName)
		{
			logger=extent.startTest(MethodName.getName());
			logger.log(LogStatus.INFO, MethodName.getName()+" has been started");
			System.out.println("start report");
		}
		
		//log test case status based on Pass/Skipped/Failed test cases
		public void getResult(ITestResult result) throws IOException
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				logger.log(LogStatus.PASS, result.getName()+" was passed");
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				logger.log(LogStatus.SKIP, result.getName()+" was Skipped");
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				/*logger.log(LogStatus.FAIL, result.getName()+" was failed");
				String path=getScreesnhot("sample");
				logger.addScreenCapture(path);*/
			}
		}
		@AfterMethod
		public void captureResult(ITestResult result) throws IOException
		{
			//call user defined function that capture logs based on execution status
			getResult(result);
		}
		
		@AfterClass
		public void stopLog()
		{
			//driver.quit();
			//end logs after all test method present under class has been executed
			extent.endTest(logger);
			//Save log under html file
			extent.flush();
		}
		
	public WebDriver getBrowser(String browser)
	{	
		//check OS and get specific browser property
		if(System.getProperty("os.name").contains("Windows"))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{	
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				//this configrations will be different for mac
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
				driver=new ChromeDriver();
				driver.get("https://www.google.com");
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				//this configrations will be different for mac
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
				driver=new FirefoxDriver();
				driver.get("https://www.google.com");
				
			}
		}
		return driver;
	}
	
	//Load Proporty file
	public void loadProportiesFile() throws IOException
	{
		
		pro=new Properties();
		
		//load first proporties file
		file=new File(System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/config/config.properties");
		fInput=new FileInputStream(file);
		pro.load(fInput);
		//Logging with log4j
		L_Logger.info("Loading config.properties");
		L_Logger.error("Sample Error");
		
		//load second proporties file
		file=new File(System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/config/or.properties");
		fInput=new FileInputStream(file);
		pro.load(fInput);
		L_Logger.info("Loading or.properties");
	}
	
	public void GetProportiesData() throws IOException
	{
		
	}
	
	//Take screenshot
	public String getScreesnhot(String fileName) throws IOException
	{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		//Create Timestamp
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd_MM_yyyy_HH_MM_SS");
		String date=formatter.format(cal.getTime());
		//Genrate File path based on timestamp 
		String path=System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/screenshot/"+fileName+date+".png";
		File actualFile=new File(path);
		FileHandler.copy(scrFile, actualFile);
		return path;
	}

	//Create explicit wait function
	public void explicitWait(WebDriver driver, long time,WebElement element)
	{
		wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Fluent wait function
	public void fluentWaitFunction(WebDriver driver,final WebElement idenityElement,long timout,long poolingTime)
	{
		FluentWait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(timout, TimeUnit.SECONDS)
				.pollingEvery(poolingTime, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		fluentWait.until(new Function<WebDriver, WebElement>() {

					public WebElement apply(WebDriver arg0) {
						// TODO Auto-generated method stub
						return idenityElement;
						
					}
					
				});
	}
	
	public String[][] getExcelData(String excelName,String sheetName) throws IOException
	{
		ExcelReader excelData = new ExcelReader();
		String excelPath=System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/data/"+excelName;
		return excelData.getExcelData(excelPath, sheetName);
	}
	
	/*public static void main(String str[]) throws IOException
	{
		TestBase test=new TestBase();
		
		//To read data from excel File
		String excelP=System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/data/Credentials.xlsx";
		String sheetN="login";
		String excelData[][];
		excelData=test.getExcelData(excelP, sheetN);
		for(int i=0;i<excelData.length;i++)
		{
			for(int j=0;j<excelData[0].length;j++)
			{
				System.out.println(excelData[i][j]);;
			}
		}
		test.loadProportiesFile();
//		test.getBrowser("chrome");
		
		//wait till element is submit button is clickable
		test.driver.get("http://abdul:82/login.do");
		WebElement submit_button=test.driver.findElement(By.cssSelector("input[type='submit']"));
		test.explicitWait(test.driver, 10, submit_button);
		System.out.println("wait completed");
		test.driver.quit();
		
		test.loadProportiesFile();
		System.out.println(test.pro.getProperty("url"));
		System.out.println(test.pro.getProperty("test"));
		
		
		//call screenshot method
		test.getScreesnhot("sample");
		
		//wait till element is submit button is clickable
		test.driver.get("http://abdul:82/login.do");
		WebElement submit_button=test.driver.findElement(By.cssSelector("input[type='sumit']"));
		test.explicitWait(test.driver, 10, submit_button);
		System.out.println("wait completed");
		test.driver.quit();
		
		//Wait till element is clickable using fluent wait
		test.driver.get("http://abdul:82/login.do");
		WebElement submit_button=test.driver.findElement(By.cssSelector("input[type='submit']"));
		test.fluentWaitFunction(test.driver, submit_button, 10, 3);
		System.out.println("wait completed");
		test.driver.quit();
		
	}*/
	
}
