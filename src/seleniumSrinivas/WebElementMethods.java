package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

public class WebElementMethods extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		WebElementMethods obj = new WebElementMethods();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.methodsDemo();
	}

	public void methodsDemo() throws InterruptedException {
		
		String searchX = "//input[@id = 'search']" ; 
		WebElement searchEle = driver.findElement(By.xpath(searchX));
		
		driver.findElement(By.xpath(searchX)).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(searchX)).sendKeys("T-Shirts");
		
		//String attr = driver.findElement(By.xpath(searchX)).getAttribute("name");  -- instead of using the whole path assign a value
		String attr = searchEle.getAttribute("name");
		System.out.println("name attribute value  : " +attr );
		
		String bgColor = searchEle.getCssValue("background-color");
		System.out.println("Background color  : " +bgColor );
		
		Point loc = searchEle.getLocation();
		System.out.println("X  : " +loc.getX() );
		System.out.println("Y  : " +loc.getY() );
		
		Dimension dim = searchEle.getSize();
		System.out.println("Width  : " +dim.getWidth() );
		System.out.println("Height  : " +dim.getHeight() );
		
		Rectangle rct = searchEle.getRect();
		System.out.println("X  : " +rct.getX() );
		System.out.println("Y  : " +rct.getY() );
		System.out.println("Width  : " +rct.getWidth() );
		System.out.println("Height  : " +rct.getHeight() );

	}
}
