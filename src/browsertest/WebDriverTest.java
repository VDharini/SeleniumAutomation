package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();
		
		System.setProperty("webdriver.gecko.driver",  "./browsersexe\\geckodriver.exe");  // instead of adding whole path use ./
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();
		
		System.setProperty("webdriver.edge.driver",  "./browsersexe\\msedgedriver.exe");  // instead of adding whole path use ./
	    driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();

	}

}
