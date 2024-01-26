package ExcelDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelReader {
	
	
	@Test
	
	public void readExcelData()throws Exception {
		FileInputStream fis=new FileInputStream("./Data/TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet=wb.getSheet("Data");
		int rowcount=sheet.getLastRowNum();
		System.out.println("Total Active Row Count: "+ rowcount);
		
		//Row row =sheet.getRow(0);
		for(int i =1;i<=rowcount;i++) {
			Row row=sheet.getRow(i);
			for(int j =0;j<row.getLastCellNum();j++) {
				org.apache.poi.ss.usermodel.Cell cell=row.getCell(j);
				if(cell==null) {
				 
				 continue;
				 }else if(cell.getCellType()==CellType.NUMERIC) {
					 System.out.println(cell.getNumericCellValue());
					
				 }else if(cell.getCellType()==CellType.STRING) {
					 System.out.println(cell.getStringCellValue());
				 }
			}
			System.out.println();
		}
		wb.close();
		fis.close();
			
	}
	
	@Test
	
	public void excelWrite() throws Exception {
		String path = "./Data/Test Data.xlsx";
		
		FileInputStream fs = new FileInputStream(path);
		
		Workbook wb = new XSSFWorkbook(fs);
		
		Sheet sheet1 = wb.getSheetAt(0);
		
		int lastRow = sheet1.getLastRowNum();
		for(int i=0; i<=lastRow; i++){
		Row row = sheet1.getRow(i);
		Cell cell = row.createCell(2);

		cell.setCellValue("WriteintoExcel");

		}

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}
	
}

