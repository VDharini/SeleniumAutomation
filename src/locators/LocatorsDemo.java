package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	    driver.findElement(By.linkText("REGISTER")).click(); 
	    driver.findElement(By.name("firstName")).sendKeys("Dharini"); 
	    driver.findElement(By.name("lastName")).sendKeys("Varadharaj"); 
	    driver.findElement(By.name("phone")).sendKeys("784383922"); 
	    driver.findElement(By.id("username")).sendKeys("dhariniv"); 
	    driver.findElement(By.name("address1")).sendKeys("no.12 xyz street"); 
	    driver.findElement(By.name("city")).sendKeys("Westborough"); 
	    driver.findElement(By.name("state")).sendKeys("MA"); 
	    driver.findElement(By.name("postalCode")).sendKeys("01581"); 
	    driver.findElement(By.id("email")).sendKeys("dharini@gmail.com"); 
	    driver.findElement(By.name("password")).sendKeys("beesain"); 
	    driver.findElement(By.name("confirmPassword")).sendKeys("beesain"); 
	    driver.findElement(By.name("submit")).click();
	    Thread.sleep(3000);
		driver.close();
	}

}
