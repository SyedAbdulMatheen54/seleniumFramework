package com.hybridFramework.helper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public WebDriverWait wait;
	//Create explicit wait function
		public WebElement waitTillElementClickable(WebDriver driver, long time,WebElement element)
		{
			wait=new WebDriverWait(driver, time);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		
		public WebElement waitTillElementVisible(WebDriver driver, long time,WebElement element)
		{
			wait=new WebDriverWait(driver, time);
			return wait.until(ExpectedConditions.visibilityOf(element));
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
}
