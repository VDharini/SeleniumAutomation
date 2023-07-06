package seleniumSrinivas;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		ScreenShots obj = new ScreenShots();
		obj.browserLaunch("chrome", "https://www.selenium.dev/");
		obj.captureScreen();
		obj.captureElement();
		}

	public void captureScreen() throws Exception {
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File homescreen = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(homescreen, new File("C:\\Users\\dhari\\OneDrive\\Desktop\\Selenium\\Screenshots\\Homepage.png"));
	}
	
		public void captureElement() throws Exception {
			
			WebElement we = driver.findElement(By.xpath("//h1"));
			File elescreen = we.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(elescreen, new File("C:\\Users\\dhari\\OneDrive\\Desktop\\Selenium\\Screenshots\\elescreen.png"));
			
			driver.close();
					
	}

}
