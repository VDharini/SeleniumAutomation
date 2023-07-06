package basicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSource {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		 String pageSource = driver.getPageSource();
		 System.out.println("Page Source  \n" +pageSource );
		Thread.sleep(2000);    // mouse over add throws
		driver.close();
	}

}
