package iframehandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeByName {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/IframeEx.html");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='c-hor-nav-toggler']")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Click Here to Navigate to Google")).click();
		
		driver.close();
	}

}
