package com.flipkart.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.flipkart.qa.base.TestBase;

public class ExcelUtil extends TestBase{
	public static Map<String,String> getMap() throws IOException
	{
		 HashMap<String,String> data = new HashMap<String,String>();
		FileInputStream fileInput = new FileInputStream("C:\\Users\\BestInd\\eclipse-workspace\\FlipkartTest\\src\\main\\java\\com\\flipkart\\qa\\testdata\\Book4.xlsx");
	
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sheet = wb.getSheet("Sheet1");
		for(int i=0;i<3;i++) 
		{
			data.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(1).getCell(i).toString());
			
		}
		return data;
	}

}
 