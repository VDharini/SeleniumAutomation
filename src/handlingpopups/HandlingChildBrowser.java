package handlingpopups;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingChildBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		Thread.sleep(3000);
		
		//getWindowHandle will get you the address of parent window
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		//getWindowHandles will get you the address of all windows
		//Set<String> ? Why Set not List (Set won't allow duplicates)
		Set<String> allWin = driver.getWindowHandles();
		System.out.println(allWin);
		
		//driver.close();
		driver.quit();
	}

}
