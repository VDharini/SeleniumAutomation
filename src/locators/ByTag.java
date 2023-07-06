package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByTag {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/amazonlink.html");
		WebElement link = driver.findElement(By.tagName("a")); // open amazon.com using tagname locator
		link.click();
		Thread.sleep(1000);
		driver.close();
	}

}
