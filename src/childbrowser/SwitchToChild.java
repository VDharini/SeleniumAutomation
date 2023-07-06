package childbrowser;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToChild {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		Thread.sleep(3000);
		
		Iterator<String>  win	= driver.getWindowHandles().iterator();
		String parent = win.next();
		String child = win.next();
		
		Thread.sleep(3000);
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//a[@class='button header__button']")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Automation");
		driver.findElement(By.id("Email")).sendKeys("test.automation.com");
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(parent);
		driver.findElement(By.name("pwd")).sendKeys("testautomation");
		Thread.sleep(3000);
		driver.close();
	
	}

}
