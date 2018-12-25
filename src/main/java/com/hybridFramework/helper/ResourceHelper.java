package com.hybridFramework.helper;

public class ResourceHelper {

	public static String getResourcePath(String resource)
	{
		String path=getBaseResourcePath()+resource;
		return path;
	}
	public static String getBaseResourcePath()
	{
		return System.getProperty("user.dir");
	}
}
