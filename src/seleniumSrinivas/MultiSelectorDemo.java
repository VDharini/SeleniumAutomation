package seleniumSrinivas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectorDemo extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		MultiSelectorDemo obj = new MultiSelectorDemo();
		obj.browserLaunch("chrome", "https://jqueryui.com/selectmenu/");
		obj.SelectDemo();
	
	}
	private void SelectDemo() throws Exception {
		
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		
		String speeddrop = "//span[@id= 'speed-button']";
		Thread.sleep(1000);
		String speedEle = "//ul/li/div[text() = '%s']";
		
		driver.findElement(By.xpath(speeddrop)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(speedEle.replace("%s", "Fast"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(speeddrop)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(speedEle.replace("%s", "Slower"))).click();
		Thread.sleep(1000);
			
		driver.switchTo().defaultContent();
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/html/MultiSelector.html");
		
		Select dest = new Select(driver.findElement(By.xpath("//select[@id='destination']")));
		WebElement fo = dest.getFirstSelectedOption();
		System.out.println(fo.getText());
		
		List<WebElement> options = dest.getOptions();
		System.out.println(options.size());
		
		dest.selectByVisibleText("Westborough");
		Thread.sleep(1000);
		dest.selectByValue("w");
		Thread.sleep(1000);
		
		Select cars = new Select(driver.findElement(By.xpath("//select[@name='Cars[]']")));
		boolean mflag = cars.isMultiple();
		System.out.println("Is multiple :" + mflag);
		
		List<WebElement> options2 = cars.getOptions();
		System.out.println(options2.size());
		for(WebElement ele:options2)
		{
			System.out.println(ele.getText());
		}
		Thread.sleep(1000);
		cars.selectByVisibleText("Nissan");
		Thread.sleep(1000);
		
		WebElement fo1 = cars.getFirstSelectedOption();
		System.out.println(fo1.getText());
		
		cars.selectByValue("BMW");
		Thread.sleep(1000);
		cars.selectByIndex(9);		
		Thread.sleep(1000);
		cars.selectByIndex(3);
		Thread.sleep(1000);
		cars.selectByIndex(6);
		Thread.sleep(1000);

		cars.deselectByIndex(3);
		Thread.sleep(1000);
		cars.deselectByVisibleText("Nissan");
		Thread.sleep(1000);
		cars.selectByValue("BMW");
		Thread.sleep(1000);
		cars.deselectAll();
		Thread.sleep(1000);

	WebElement carsDrop = driver.findElement(By.xpath("//select[@name='Cars[]']"));
	List<WebElement> opts =carsDrop.findElements(By.xpath("//option"));
	System.out.println(opts.size());
	System.out.println("Multi Selector Options :");
	for(WebElement ele : opts)
	{
		System.out.println(ele.getText());
	}
	
	}

}
