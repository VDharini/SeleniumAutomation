package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		HandlingActions obj = new HandlingActions();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.actionsDemo();
		}

	public void actionsDemo() throws Exception  {
		
		
		WebElement searchEle	= driver.findElement(By.xpath("//input[@id = 'search']")); // creating WebElement
		
		Actions myactions = new Actions(driver);       //creating Actions class objects      //step1
		
		Action builder = myactions.sendKeys(searchEle, "T-Shirts").sendKeys(Keys.ENTER).build();    //step2
		builder.perform();      // build() and perform() is mandatory without them we cannot execute.  //step3
		
		searchEle	= driver.findElement(By.xpath("//input[@id = 'search']")); // Handling Stale Element Exception
		Action builder2 = myactions.sendKeys(searchEle, "Cotton Dresses")
													.sendKeys(Keys.chord(Keys.CONTROL, "A"))
													.contextClick().build();     // contextClick is similar to right click 
		builder2.perform();    // keys.chord is used to send more than one key control 
		
		//without creating objects 
		WebElement createAcct = driver.findElement(By.xpath("//a[text() = 'Create an Account']"));
		new Actions(driver).click(createAcct).build().perform();  // short cut for step 1,2,3 in the previous lines --in single statement
		
		new Actions(driver).keyDown(Keys.CONTROL)
										.sendKeys(Keys.ARROW_DOWN)
										.sendKeys(Keys.ARROW_DOWN)
										.sendKeys(Keys.ARROW_DOWN)
										.keyUp(Keys.CONTROL)
										.build().perform();
		
		
		
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dst = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		new Actions(driver).dragAndDrop(src, dst)
										.dragAndDropBy(src, dst.getLocation().getX()+50, dst.getLocation().getY()+50)
										.build().perform();
		
		//  Move to element
		driver.switchTo().defaultContent();
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		
		WebElement ageIn = driver.findElement(By.xpath("//input[@id='age']"));
		Thread.sleep(3000);

		new Actions(driver).moveToElement(ageIn).build().perform();
		

		WebElement tooltips = driver.findElement(By.xpath("//a[text()='Tooltips']"));
		Thread.sleep(3000);

		new Actions(driver).moveToElement(tooltips).build().perform();
		
		WebElement thermaroller = driver.findElement(By.xpath("//a[text()='ThemeRoller']"));
		Thread.sleep(3000);

		new Actions(driver).moveToElement(thermaroller).build().perform();
		
	}

}


 