package seleniumSrinivas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
	
	public WebDriver driver;
	
	public void  browserLaunch(String btype, String url) throws Exception{
		
		System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",  "./browsersexe\\geckodriver.exe");
		
		if(btype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			}
		else if(btype.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		}

}
