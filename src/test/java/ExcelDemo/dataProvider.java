package ExcelDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name="empLogin")
	
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("./Data/Test Data.xlsx","Data");
		return arrayObject;
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		
		Cell cell;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			
			Workbook wb=WorkbookFactory.create(fs);
			
			//Sheet sh = wb.getSheet(sheetName);
			Sheet sh=wb.getSheet(sheetName);
		
            Row row=sh.getRow(0);
            
			int totalNoOfCols = row.getLastCellNum();
			
			
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			
			
			System.out.println("Total Row Count: "+totalNoOfRows);
			
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols]; // 4 0,1,2,3,4
			
			for (int i= 0; i <totalNoOfRows-1; i++) {

				for (int j=0; j <totalNoOfCols; j++) {
					
					row=sh.getRow(i+1); // 1,0
					
					cell=row.getCell(j);
					
					arrayExcelData[i][j] = cell.getStringCellValue().toString();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		
	}
		return arrayExcelData;

	}
}
