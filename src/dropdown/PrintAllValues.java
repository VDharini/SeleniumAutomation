package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllValues {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement countryDropdown = driver.findElement(By.name("country"));
		Select sel = new Select(countryDropdown);
		
		List<WebElement> allOptions = sel.getOptions();
		System.out.println("Dropdown lists count  :" +allOptions.size());
		
		for (WebElement options : allOptions) 
		{
			System.out.println(options.getText());
		}
			Thread.sleep(3000);
			driver.close();
	}

}
