package com.automation.DataManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelData {
  public static String filename="C:\\Users\\sakth\\OneDrive\\Desktop\\TestData.xlsx";
  public static String sheetName="Data";
  public static FileInputStream fis;
  public static Sheet sheet;
	public static void loadExcel() throws Exception{
		 System.out.println("Load Excel Sheet.........");
		File file =new File(filename);
		try {
			fis = new FileInputStream(file);
			Workbook wb=WorkbookFactory.create(fis);
			sheet=wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
		 
			e.printStackTrace();
		}
		fis.close();
	}
	public static Map<String,Map<String,String>> getDataMap() throws Exception{
		if(sheet==null){
			loadExcel();
		}
		Map<String, Map<String,String>> parentMap = new HashMap<String, Map<String,String>>();
        Map<String, String> childMap = new HashMap<String, String>();
        Iterator<Row> rowIterator = sheet.iterator();

        while( rowIterator.hasNext() )
        {
            Row row = rowIterator.next();
            childMap.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
        }

        parentMap.put("MASTERDATA", childMap);

        return parentMap;
		
	}
	 public static String getValue(String key) throws Exception {
	        Map<String,String> mapValue = getDataMap().get("MASTERDATA");
	        String retValue = mapValue.get(key);

	        return retValue;
	    }
	 @Test
	 public void excel() throws Exception{
	        System.out.println(getValue("UserName"));
	    }
}
