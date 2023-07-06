package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/multipleselect.html");
		
		WebElement toolsDropdown = driver.findElement(By.name("multipleselect[]"));
		Select sel = new Select(toolsDropdown);
		
		System.out.println("Is the dropdown a multiselect  :"+sel.isMultiple());
		
		sel.selectByIndex(0);
		Thread.sleep(2000);
		sel.selectByIndex(1);
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByIndex(3);
		Thread.sleep(2000);
		sel.selectByIndex(4);
		Thread.sleep(2000);
		sel.selectByIndex(5);
		Thread.sleep(2000);
				
		System.out.println(sel.getFirstSelectedOption().getText());
		
		sel.deselectByIndex(4);
		Thread.sleep(2000);
		sel.deselectAll();
		Thread.sleep(2000);
		driver.close();

				

	}

}
