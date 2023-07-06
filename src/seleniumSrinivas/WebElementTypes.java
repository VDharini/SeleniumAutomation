package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementTypes extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		WebElementTypes obj = new WebElementTypes();
		obj.browserLaunch("chrome", "file:///C:/Users/dhari/OneDrive/Desktop/Selenium/html/CreateUser.html");
		obj.methodsTypeDemo();
	}
	
	public void methodsTypeDemo() throws Exception {
		
		// input textbox
		String fn = driver.findElement(By.xpath("//input[@id='fname']")).getAttribute("value");
		System.out.println("Default First Name  :" +fn);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Dharini");
		Thread.sleep(1000);
		fn = driver.findElement(By.xpath("//input[@id='fname']")).getAttribute("value");
		System.out.println("CurrentFirst Name  :" +fn);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Varadharaj");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("password123");
		Thread.sleep(1000);
		
		// radio button
		driver.findElement(By.xpath("//input[@id='male']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='female']")).click();
		Thread.sleep(1000);
		
		//select - single attribute
		WebElement ys = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(ys);
		boolean isMulti = yearSelect.isMultiple();
		System.out.println("Is multi selector  :"+ isMulti);
		yearSelect.selectByVisibleText("2002");
		Thread.sleep(1000);
		
		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		monthSelect.selectByIndex(2);
		Thread.sleep(1000);

		Select daySelect = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		daySelect.selectByValue("10");
		Thread.sleep(1000);

		//text area
		 String tatxt = driver.findElement(By.xpath("//textarea[@id='address']")).getText();
		 System.out.println("Default text  :" +tatxt);
		 driver.findElement(By.xpath("//textarea[@id='address']")).clear();
			Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("295 TPK Road \n APT 122 \n Westborough");
		Thread.sleep(1000);
		tatxt = driver.findElement(By.xpath("//textarea[@id='address']")).getAttribute("value");
		 System.out.println("New text  :" +tatxt);
		 
		 //checkbox
		 boolean isSel = driver.findElement(By.xpath("//input[@name='h1']")).isSelected();
		 System.out.println(" Is checkbox selected  :" +isSel );
			Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@name='h1']")).click();
			Thread.sleep(1000);
		 isSel = driver.findElement(By.xpath("//input[@name='h1']")).isSelected();
		 System.out.println(" Is checkbox selected  :" +isSel );
			Thread.sleep(1000);
		 
		 //submit
		 driver.findElement(By.xpath("//input[@value='Submit']")).submit();
						
		driver.get("file:///C:/Users/dhari/OneDrive/Desktop/Selenium/html/CreateUserPg2.html");
		 
		 String smsg = driver.findElement(By.xpath("//h2")).getText();
		 if(smsg.contains("User Creation Successful"))
		 {
			 System.out.println("User created successfully");
		 }else 
		 {
			 throw new Exception("User creation failed");
		 }
		 
	}
}
