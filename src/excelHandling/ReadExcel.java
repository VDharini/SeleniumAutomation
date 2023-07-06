package excelHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// 1. Create the Excel file
		File file = new File("C:\\\\Users\\\\dhari\\\\OneDrive\\\\Desktop\\\\Selenium\\\\Data\\\\ExcelData.xlsx");
		
		//2. Pass the file to a class called as FileInputStream to Stream the contents from this file
		FileInputStream fis = new FileInputStream(file);
		
		//3. Create an Object of XSSFWorkbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//4.Read the data
		String row = wb.getSheetAt(0).getRow(0).getCell(0).toString();
		String col = wb.getSheetAt(0).getRow(0).getCell(1).toString();
		System.out.println(row);
		System.out.println(col);
		
		wb.close();

	}

}
