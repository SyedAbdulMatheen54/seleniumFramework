package com.hybridFramework.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHelper {
	
	public Logger registerClass(String className)
	{
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/java/com/hybridFramework/Resource/log4j.properties"));
		return Logger.getLogger(className);
	}

}
