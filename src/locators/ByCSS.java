package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByCSS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/cssSample.html");
		driver.findElement(By.tagName("input")).sendKeys("dhariniv");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys("sam12344");
		Thread.sleep(3000);
		driver.close();
	}

}
