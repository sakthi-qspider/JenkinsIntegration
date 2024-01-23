package com.automation.DataManagement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatawithColumnName {
	
	FileInputStream fis;
	static Sheet sheet;
	Workbook wb;
	public  ReadDatawithColumnName(String Path,String sheetName) throws EncryptedDocumentException, IOException{
		 fis=new FileInputStream(Path);
		 wb = WorkbookFactory.create(fis);
		 sheet=wb.getSheet(sheetName);
	}

	public static String fetchDataFromExcel(String colName){
		// TODO Auto-generated method stub
		Row row =null;
		Cell cell =null;
		String data = null;
		
		
		row =sheet.getRow(0);
		int rowcount = sheet.getFirstRowNum();
		
		int col_num=0;
		
		for(int i =0;i<row.getLastCellNum();i++){
			
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_num=i;
		}
		
		row=sheet.getRow(1);
		cell=row.getCell(col_num); //1,1
		if(cell.getCellType()==CellType.STRING){
			data=cell.getStringCellValue().toString();
		}else if(cell.getCellType()==CellType.NUMERIC){
			System.out.println("Cell Type is numberic");
			 data=String.valueOf(cell.getNumericCellValue());
		}
		return data;
		
		
		
		
		
			
		
	}

}
