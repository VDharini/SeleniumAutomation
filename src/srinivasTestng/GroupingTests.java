package srinivasTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GroupingTests {
	public WebDriver driver;
	String btype = "chrome";
	String url = "https://magento.softwaretestingboard.com/";
	
	@BeforeGroups(groups = {"sanity"})
	public void bg() {
		System.out.println("Executes Before group");
		}
	@AfterGroups(groups = {"regression"})
	public void ag() {
		System.out.println("Executes After group");
		} 
	
	
	@Test(priority = 1, groups= {"sanity", "regression"})
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
		
	}
	@Test(priority = 3, groups ={"sanity"})
	public void searchDress() throws Exception {
		String sxpath = "//input[@id = 'search']";     //  in future if we make changes it's good to use variables
		
		driver.findElement(By.xpath(sxpath)).sendKeys("T-Shirts");
		driver.findElement(By.xpath(sxpath)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Test(priority = 5, groups= {"regression"})
	public void addToCart() {
		System.out.println("Added to cart");
	}
	
	@Test(priority = 7)
	public void processPayment() {
		System.out.println("Payment is processed");
	}
	
	@Test(priority = 9, groups= {"sanity", "regression"})
	public void closeBrowser() {
		driver.quit();
	}

}
