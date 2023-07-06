package iframehandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeProgram1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe"); 
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rediff.com/");
		
		List<WebElement>  iframes = driver.findElements(By.tagName("iframe"));
		int totalframes = iframes.size();
		System.out.println("Total number of frames :  "+totalframes);
		
		driver.close();
		
	}

}
