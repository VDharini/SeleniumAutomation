package seleniumSrinivas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchAndControlDemo {

	public String btype = "chrome" ;
	public WebDriver driver;
	public String url = "http://selenium.dev";
	
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./browsersexe/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./browsersexe/geckodriver.exe");
		
		if(btype.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}

		else if(btype.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}	
		driver.get(url);
		
		String curl = driver.getCurrentUrl();
		System.out.println("Current url  :  " +curl);
		String title = driver.getTitle();
		System.out.println("Page Title :  " +title);
	}
	public static void main(String[] args) {
	LaunchAndControlDemo obj = new LaunchAndControlDemo();
		obj.launchBrowser();
		
		
	}
	
}
