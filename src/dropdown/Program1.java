package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement countryDropdown = driver.findElement(By.name("country"));
		Select sel = new Select(countryDropdown);
		
		// there are 3 ways to select a value from dropdown
		//1 using index
		sel.selectByIndex(10);
		Thread.sleep(2000);
		
		//2 using visible text -- commonly used
		sel.selectByVisibleText("ARGENTINA");
		Thread.sleep(2000);
		
		//3 using value
		sel.selectByValue("ANGOLA");
		Thread.sleep(2000);

		driver.close();
		

	}

}
