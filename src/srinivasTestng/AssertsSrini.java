package srinivasTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import static org.testng.Assert.*;   -- Import Static members
import org.testng.annotations.Test;

public class AssertsSrini {
        //assertEquals(false, false);
	   // assertTrue(false);  // if you use Static members no need for Assert.
	public WebDriver driver;
	String btype = "chrome";
	String url = "https://magento.softwaretestingboard.com/";
	
	@Test(priority = 1)
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./browsersexe\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./browsersexe\\geckodriver.exe");

		if (btype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (btype.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Validation to check url contains
		String curl = driver.getCurrentUrl();
		url = "https://magento.softwaretestingboard.com/";
		// Assert.assertEquals(curl, url);
		//Assert.assertEquals(curl, url, "url mismatched");  // success if both values are equal 
		//Assert.assertNotEquals(curl, url, "url mismatched"); //success if both values not equals
		boolean urlcheck = curl.equalsIgnoreCase(url);
		//Assert.assertFalse(urlcheck," Url mismatched"); //Assert is successful if the condition is false
		Assert.assertTrue(urlcheck," Url mismatched"); //Assert is successful if the condition is true
		

		System.out.println("Executes if Assert is true");
	}
	@Test(priority = 3)
	public void searchDress() throws Exception {
		String sxpath = "//input[@id = 'search']";     //  in future if we make changes it's good to use variables
		
		driver.findElement(By.xpath(sxpath)).sendKeys("T-Shirts");
		Thread.sleep(2000);
		String actValue = driver.findElement(By.xpath(sxpath)).getAttribute("value");
		if(!actValue.equalsIgnoreCase("Sweat-Shirts")) {
			Assert.fail("Expected String not entered");
		}
		//Assert.fail();  ---- Assert fails after printing T-Shirts without entering
		driver.findElement(By.xpath(sxpath)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void closeBrowser() {
		//driver= null;  // to fail assertNotNull 
		Assert.assertNotNull(driver);
		driver.quit();
	}
}
