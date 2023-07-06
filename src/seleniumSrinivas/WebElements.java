package seleniumSrinivas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElements extends LaunchBrowser{

	public void webElementIdentify() throws Exception {
		  
		String ptitle = driver.getTitle();
		if(ptitle.contains("Home Page")) {
			System.out.println("Found Home Page");
		}
		else  {
			System.out.println("Home page not found");
		}
		
		WebElement cac = driver.findElement(By.linkText("Create an Account"));
		cac.click();
		
		WebElement fn = driver.findElement(By.id("firstname"));
		fn.click();
		fn.sendKeys("Dha");
		
		WebElement ln = driver.findElement(By.name("lastname"));
		ln.click();
		ln.sendKeys("Var");
		 
		driver.findElement(By.className("checkbox")).click();
		
		driver.findElement(By.partialLinkText("Sign In")).click();
		
		List<WebElement> inBoxes = driver.findElements(By.tagName("input")) ;
		System.out.println("No. of input boxes  :" + inBoxes.size());
		
		inBoxes.get(3).sendKeys("roni_cost@example.com");
		inBoxes.get(4).sendKeys("roni_cost@example.com");
		
		driver.findElement(By.id("send2")).click();

		driver.close();
	}
	
	public static void main(String[] args) throws Exception {
		WebElements obj = new WebElements();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.webElementIdentify();
		
			}

}
