package com.hybridFramework.helper;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHelper {

	 private WebDriver driver;
	
	//help in select option of dropdown with text
	public void  selectUsingText(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void selectUsingIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public List<String> getAllDropdownValue(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> eachOption = select.getOptions();
		List<String> val=new LinkedList<String>();
		for(WebElement elementt: eachOption)
		{
			val.add(elementt.getText());
		}
		return val;
	}
	
	public String getSelectedDropdownItem(WebElement element)
	{
		Select select=new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
}
