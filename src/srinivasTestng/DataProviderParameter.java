package srinivasTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderParameter {
public WebDriver driver;
	
	@Test(priority = 1, dataProvider= "lb")
	public void launchBrowser(String btype, String url  ) {
		
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
		
	}
	
	@Test(priority = 3, dataProvider= "search")
	public void searchDress(String searchStr) throws Exception {
		String sxpath = "//input[@id = 'search']";     //  in future if we make changes it's good to use variables
		
		driver.findElement(By.xpath(sxpath)).clear();
		
		driver.findElement(By.xpath(sxpath)).sendKeys(searchStr);
		driver.findElement(By.xpath(sxpath)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider(name = "search")
	public String[ ][ ] searchData() {
		String[ ][ ] sdata = { {"T-Shirts"},
				{"Cotton Dresses"},
				{"Casual Dresses"},
				{"Summer Dresses"}					
		};
		return sdata;
	}
	@DataProvider(name = "lb")
	public String[ ][ ] lbData() {
		String[ ][ ] sdata = { {"chrome", "https://magento.softwaretestingboard.com/"},
						
		};
		return sdata;
	}
}
