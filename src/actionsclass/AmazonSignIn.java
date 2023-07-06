package actionsclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonSignIn {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");

		WebElement signIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		Actions action = new Actions(driver);
		action.moveToElement(signIn).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

}
