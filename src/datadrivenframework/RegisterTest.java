package datadrivenframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {
	
	@DataProvider(name = "registerdata")
	public Object[][] registerdata()
	{
		Object[][] data = new Object[2][4];
		data[0][0] = "Dharini";
		data[0][1] = "Vara";
		data[0][2] = "4639453098";
		data[0][3] = "manager@test.com";
		
		data[1][0] = "Sasi";
		data[1][1] = "Vara";
		data[1][2] = "46346653098";
		data[1][3] = "test@test.com";
		
		return data;
	}
@Test(dataProvider = "registerdata")
public void testRegistrationForm(String fn, String ln, String ph, String email) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
	WebDriver driver  = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://demo.guru99.com/test/newtours/");
    driver.findElement(By.linkText("REGISTER")).click(); 
    driver.findElement(By.name("firstName")).sendKeys(fn); 
    driver.findElement(By.name("lastName")).sendKeys(ln); 
    driver.findElement(By.name("phone")).sendKeys(ph); 
    driver.findElement(By.id("username")).sendKeys(email); 
    
    Thread.sleep(3000);
  		driver.close();
}
}
