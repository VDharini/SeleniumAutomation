package seleniumSrinivas;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateDataExcel {

	public static void main(String[] args) throws IOException {
		
		String[ ][ ] mydata = {{ "T-Shirts" , "test1@test.com"},
											{ "Casual Dresses" , "test2@test.com"},
											{ "Cotton Dresses" , "test3@test.com"},
											{ "Summer Dresses" , "test4@test.com"},
										};
		
		XSSFWorkbook book  = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("TestData");
		
		for(int r = 0; r<mydata.length; r++) {
			XSSFRow row = sheet.createRow(r);
			for(int c = 0; c < mydata[r].length; c++) {
					XSSFCell cell = row.createCell(c);
					cell.setCellValue(mydata[r][c]);
			      }
			}
		FileOutputStream myfile = new FileOutputStream("C:\\Users\\dhari\\OneDrive\\Desktop\\Selenium\\Data\\ExcelData.xlsx");
		book.write(myfile);
		
		if(book !=null) {
			book.close();
		}
		System.out.println("File Created");
	}

}
