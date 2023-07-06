package seleniumSrinivas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FramesHW extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		FramesHW obj = new FramesHW();
		obj.browserLaunch("chrome", "https://docs.oracle.com/javase/8/docs/api/");
		obj.handlingFrames();
		}

	public void handlingFrames() throws Exception {
		
		List<WebElement> frms =driver.findElements(By.xpath("//frame"));
		System.out.println("Number of frames : "+ frms.size());
		driver.switchTo().frame(0); // Switch to first frame
		driver.findElement(By.xpath("//a[text()='java.applet']")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1); // Switch to second frame
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Applet']")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
		//driver.switchTo().frame(2); // Switch to third frame
		//Thread.sleep(1000);
		WebElement fe = driver.findElement(By.xpath("//frame[@name='classFrame']"));
		driver.switchTo().frame(fe);
		boolean dflag =driver.findElement(By.xpath("//h2[text()='Class Applet']")).isDisplayed();
		System.out.println("Class displayed : " + dflag);
		
		
		String smsg = driver.findElement(By.xpath("//h2[@class='title']")).getText();
		 if(smsg.contains("Class Applet"))
		 {
			 System.out.println("Verified");
		 }else 
		 {
			 throw new Exception("Failed");
		 }
		 Thread.sleep(1000);
			driver.switchTo().defaultContent();
			
			driver.close();
	}
	

	
}
