package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FramesDemo extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		FramesDemo obj = new FramesDemo();
		obj.browserLaunch("chrome", "file:///C:/Users/dhari/OneDrive/Desktop/Selenium/html/frameChat.html");
		obj.handleFrames();
	
	}

	void handleFrames() throws Exception {
		
		driver.switchTo().frame(0); // Switch using index
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Frame1txt']")).clear();
		driver.findElement(By.xpath("//input[@id='Frame1txt']")).sendKeys("Frame1 text is done");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();  // switch to main frame
		
		driver.switchTo().frame("frame_b");  // Switch using name or id
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Frame2txt']")).clear();
		driver.findElement(By.xpath("//input[@id='Frame2txt']")).sendKeys("Frame2 text is done");
		Thread.sleep(1000);
		driver.switchTo().defaultContent(); // switch to main frame
		
		WebElement f3 = driver.findElement(By.xpath("//input[@id='Frame3txt']"));
		driver.switchTo().frame(f3);  // Switch using WebElement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Frame3txt']")).clear();
		driver.findElement(By.xpath("//input[@id='Frame3txt']")).sendKeys("Frame3 text is done");
		Thread.sleep(1000);
		driver.switchTo().defaultContent(); // switch to main frame

		
	}

}
