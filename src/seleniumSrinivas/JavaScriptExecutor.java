package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		JavaScriptExecutor obj = new JavaScriptExecutor();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.jsDemo();
		}

	public void jsDemo() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String curl = js.executeScript("return document.URL;").toString(); // to get the current url
		System.out.println("Current Url : " +curl);		
		String ptitle = js.executeScript("return document.title;").toString();  // to get the page title
		System.out.println("Page Title : " +ptitle);	
		
		WebElement sinp = driver.findElement(By.xpath("//input[@id = 'search']"));
		WebElement cracc = driver.findElement(By.xpath("//a[text() = 'Create an Account']"));
		// we can write multiple js in a single line
		// js.executeScript("arguments[0].click(); arguments[0].value='T-Shirts';",  sinp);  
		
		js.executeScript("arguments[0].click(); arguments[0].value='T-Shirts'; arguments[1].click();" , sinp, cracc);  //value = sendkeys
											// we can write multiple methods in a single line
		
		js.executeScript("window.location = 'https://www.selenium.dev/' ");
		Thread.sleep(2000);
		
		//scroll --  we have to use js executor to scroll up and down we don't have a method in selenium
		js.executeScript("window.scrollBy(0,500)"); //to scroll down
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-300)"); // to scroll up(use -)
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // to scroll to the bottom of the page
		Thread.sleep(2000);
		
		WebElement ele =driver.findElement(By.xpath("//span[@class='selenium-logo']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
			}

}
