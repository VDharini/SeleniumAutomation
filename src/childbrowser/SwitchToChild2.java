package childbrowser;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToChild2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		Thread.sleep(3000);
		
		String parent = driver.getWindowHandle();
		Iterator<String>  windows	= driver.getWindowHandles().iterator();
		
		while(windows.hasNext())
		{
		driver.switchTo().window(windows.next());
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("actiTIME - Time Tracking Software for Cost-Effective Projects"))
		{
			driver.close();
		}
	}
	
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		driver.findElement(By.name("pwd")).sendKeys("testautomation");
		Thread.sleep(3000);
		driver.close();
		
	}
}
