package TestCases;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo2 {
	
	

	

	    public static void main(String[] args) {
	        try {
	            // Specify the path to your Excel file
	            String filePath = "./Data/TestData.xlsx";

	            // Open the Excel file
	            FileInputStream fileInputStream = new FileInputStream(filePath);
	            Workbook workbook = new XSSFWorkbook(fileInputStream);

	            // Specify the sheet name (assuming the first sheet)
	            Sheet sheet = workbook.getSheetAt(0);

	            // Iterate through rows and columns to read data
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                	if((cell.toString().equals("UserName"))&&(cell.toString().equals("Password"))) {
	                		
	                	}else {
	                		System.out.print(cell.toString() + "\t");
	                	}
	                    
	                }
	                System.out.println(); // Move to the next line after each row
	            }

	            // Close resources
	            workbook.close();
	            fileInputStream.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


