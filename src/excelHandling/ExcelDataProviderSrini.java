package excelHandling;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProviderSrini {
	
	@DataProvider (name="getExcelData")
	public String[ ][ ] readExcelData() throws Exception{
		
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\dhari\\OneDrive\\Desktop\\Selenium\\Data\\ExcelData.xlsx");
		
		XSSFSheet sheet = book.getSheet("TestData");
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[ ][ ] mydata = new String[rows][cols];
		
		for(int r=0; r < rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0; c<cols; c++) {
				XSSFCell cell = row.getCell(c);
				String cdata = cell.getStringCellValue();
				mydata[r][c] = cdata;
			}
		}
	
		book.close();
		
		return mydata;
	}

}
