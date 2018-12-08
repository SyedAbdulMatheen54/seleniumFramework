package com.hybridFramework.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.hybridFramework.testBase.TestBase;
public class ExcelReader extends TestBase{

	//Method to Read excel Data from any file
	public String[][] getExcelData(String excelPath, String sheetName) throws IOException
	{
		L_Logger.info("Get Excel Data");
		System.out.println(excelPath);
		FileInputStream excelFile=new FileInputStream(new File(excelPath));
		XSSFWorkbook wb=new XSSFWorkbook(excelFile);
		XSSFSheet ws=wb.getSheet(sheetName);
		int rowCount=ws.getLastRowNum();
		int colCount=ws.getRow(0).getLastCellNum();
		String excelData[][]=new String[rowCount+1][colCount];
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				excelData[i][j]=ws.getRow(i).getCell(j).toString();
			}
		}
		return excelData;
	}
}
