package excelHandling;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {

	public static void main(String[] args) {
		
		try 
		{
			File file = new File("C:\\\\Users\\\\dhari\\\\OneDrive\\\\Desktop\\\\Selenium\\\\Data\\\\ExcelData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new  XSSFWorkbook(fis);
			int count = wb.getSheet("TestData").getLastRowNum()+1;
			System.out.println("Total number of rows  :" + count);
			
			for(int i = 0; i<count ; i++)
			{
				String row  = wb.getSheet("TestData").getRow(i).getCell(0).toString();
				String col  = wb.getSheet("TestData").getRow(i).getCell(1).toString();
				System.out.println(row  + "  : " +col);
				
			}
			
			wb.close();
				}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
