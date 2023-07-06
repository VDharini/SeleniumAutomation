package datadrivenframework;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseTest {
	
	@DataProvider(name = "actiData")
	public Object[ ][ ] testData()
	{
		Object[ ][ ] data = new Object[2][2];
		
		data[0][0] = "admin";
		data[0][1] = "manager";
		
		data[1][0] = "admin";
		data[1][1] = "manager";
		
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
