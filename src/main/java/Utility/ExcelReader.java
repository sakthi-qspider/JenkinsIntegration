package Utility;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	


	    public static void main(String[] args) throws IOException {
	        String filePath = "path/to/your/test_cases.xlsx";
	        String sheetName = "Sheet1"; // Replace with your sheet name

	        // Open the Excel file
	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	        Workbook workbook = WorkbookFactory.create(fileInputStream);

	        // Assuming the column names are in the first row
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row headerRow = sheet.getRow(0);

	        // Find the column index based on column name
	        int columnNameIndex = getColumnIndex(headerRow, "ColumnName"); // Replace with your column name

	        // Iterate through rows and read data based on column name
	        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	            Row dataRow = sheet.getRow(rowIndex);
	            Cell cell = dataRow.getCell(columnNameIndex);

	            // Access cell value using cell.getStringCellValue(), cell.getNumericCellValue(), etc.
	            String cellValue = cell.getStringCellValue();
	            System.out.println("Value in row " + rowIndex + ": " + cellValue);
	        }

	        workbook.close();
	        fileInputStream.close();
	    }

	    // Helper method to get the column index based on column name
	    private static int getColumnIndex(Row headerRow, String columnName) {
	        int columnIndex = -1;
	        for (Cell cell : headerRow) {
	            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
	                columnIndex = cell.getColumnIndex();
	                break;
	            }
	        }
	        return columnIndex;
	    }
	}


