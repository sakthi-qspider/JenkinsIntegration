package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Demo {



	
	    public static void main(String[] args) throws IOException {
	        String filePath = "path/to/your/test_cases.xlsx";
	        String sheetName = "Sheet1"; // Replace with your sheet name

	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	        Workbook workbook = WorkbookFactory.create(fileInputStream);

	        Sheet sheet = workbook.getSheet(sheetName);

	        // Assuming the column names are in the first row
	        Row headerRow = sheet.getRow(0);
	        int columnNameIndex = getColumnIndex(headerRow, "ColumnName"); // Replace with your column name

	        // Find or create a row where you want to write the data
	        int rowIndex = 1; // Replace with the desired row index
	        Row dataRow = sheet.getRow(rowIndex);
	        if (dataRow == null) {
	            dataRow = sheet.createRow(rowIndex);
	        }

	        // Get or create the cell based on the column name
	        Cell cell = dataRow.getCell(columnNameIndex);
	        if (cell == null) {
	            cell = dataRow.createCell(columnNameIndex);
	        }

	        // Write data to the cell
	        cell.setCellValue("New Value"); // Replace with the desired value

	        // Save the changes
	        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
	            workbook.write(fileOut);
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

