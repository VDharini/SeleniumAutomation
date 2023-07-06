package browsertest;

import org.openqa.selenium.edge.EdgeDriver;

public class Edgetest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver",  "./browsersexe\\msedgedriver.exe");  // instead of adding whole path use ./
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);    // mouse over add throws
		driver.close();


	}

}
