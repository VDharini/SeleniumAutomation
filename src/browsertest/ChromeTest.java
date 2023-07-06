package browsertest;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\dhari\\OneDrive\\Desktop\\JAVA\\WorkSpace\\SeleniumConcepts\\browsersexe\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");  // instead of adding whole path use ./
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();
	}

}
   