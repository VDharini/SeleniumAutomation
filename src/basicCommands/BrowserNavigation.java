package basicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000); 
		driver.navigate().to("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000); 
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(1000); 
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		Thread.sleep(1000); 
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		Thread.sleep(1000); 
		driver.close();
	}

}
