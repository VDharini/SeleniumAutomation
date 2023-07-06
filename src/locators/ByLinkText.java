package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByLinkText {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/amazonlink.html");
	    driver.findElement(By.linkText("Amazon")).click(); 
		Thread.sleep(3000);
		driver.close();
	}

}
