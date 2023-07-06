package datadrivenframework;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelLib;

public class LoginExcel extends BaseTest{
 
	@DataProvider(name = "actiData")
	public Object[ ][ ] testData()
	{
		ExcelLib excel = new ExcelLib("./testData/actiData.xlsx");
		int row = excel.getRowCount(0);
		Object[ ][ ] data = new Object[row][2];
		
		for(int i = 0; i < row; i++)
		{
			data[i][0] = excel.getCellData(0, i , 0);
			data[i][1] = excel.getCellData(0, i , 1);
		}
			return data;
			
		}
		
		@Test(dataProvider = "actiData")
		public void testLoginWithValidCredentials(String username, String password)
		{
			
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.name("pwd")).sendKeys(password);
			driver.findElement(By.id("loginButton")).click();
			driver.findElement(By.id("logoutLink")).click();
			
		}
	}
