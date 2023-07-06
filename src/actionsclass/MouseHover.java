package actionsclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.actimind.com/");

		WebElement areaOfExp = driver.findElement(By.xpath("//a[@class='c-link dropdown-toggle']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(areaOfExp).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu c-menu-type-inline']//li//a[@href='design.html']"));
		Thread.sleep(3000);
		driver.close();
	}

}
