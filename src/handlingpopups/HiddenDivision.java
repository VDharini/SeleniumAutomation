package handlingpopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDivision {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/");
		
		driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
		driver.findElement(By.linkText("21")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtReturnJourneyDate']")).click();
		driver.findElement(By.linkText("29")).click();
		
		Thread.sleep(3000);
		driver.close();
	}

}
