package seleniumSrinivas;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {

	public WebDriver driver;
	public String btype = "chrome";
	public String url = "https://magento.softwaretestingboard.com/";
	
	public void  ExplicitWaitsDemo() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",  "./browsersexe\\geckodriver.exe");
		
		if(btype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			}
		else if(btype.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // applicable to all the lines
		
		WebDriverWait wait = new WebDriverWait(driver, 15);  //WebDriverWait is in Java Class
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id ='search']")));
		
	 	Thread.sleep(2000);
			
		driver.close();
		}

	public static void main(String[] args) throws Exception {
		
		ExplicitWaits obj = new ExplicitWaits();
		obj.ExplicitWaitsDemo();
	}

}