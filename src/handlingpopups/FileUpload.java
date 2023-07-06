package handlingpopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.foundit.in/");
		
		driver.findElement(By.xpath("//div[contains(text(), 'Upload Resume')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\dhari\\OneDrive\\Desktop\\Selenium\\SR.txt");
		Thread.sleep(3000);

	}

}
