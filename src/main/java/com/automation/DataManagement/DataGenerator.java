package com.automation.DataManagement;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	
@DataProvider(name="testData")
public String[][]getdata(){
	String[][] data =getExcelData("./Data/TestData.xlsx","Data");
	return data;
}
public static String[][] getExcelData(String path, String sheetName){
	
	String[][] data = null;
	
	
	try{
		Cell cell;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(0);
		int rowcount =sheet.getPhysicalNumberOfRows();
		int cellcount=row.getLastCellNum();
		data= new String[rowcount-1][cellcount];
		for(int i=1;i<rowcount;i++){
			for(int j=0;j<cellcount;j++){
				row=sheet.getRow(i);
				cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue().toString();
				
			}
		}
	}catch(Exception e){
		System.out.println("The exception is: " +e.getMessage());
	}
	return data;

	
	}
}
	



