package browsertest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",  "./browsersexe\\geckodriver.exe");  // instead of adding whole path use ./
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();

	}

}
