package seleniumSrinivas;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverOptions {

	public String btype = "chrome";
	public WebDriver driver;
	public String url = "http://selenium.dev";
	
	public void browOps() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",  "./browsersexe\\chromedriver.exe");
	System.setProperty("webdriver.gecko.driver",  "./browsersexe\\geckodriver.exe");

	if(btype.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}
	else if(btype.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		}
	
	driver.get(url);
	Thread.sleep(1000);
	System.out.println("Navigating to jqueryui");
	driver.navigate().to("http://jqueryui.com");
	Thread.sleep(1000);
	System.out.println("Click back button");
	driver.navigate().back();
	Thread.sleep(1000);
	driver.navigate().forward();
	Thread.sleep(1000);
	driver.navigate().refresh();
	
	// WebDriver manage Options
	driver.get("http://google.com");
	Set<Cookie> cks = driver.manage().getCookies();
	System.out.println(" No. of cookies  : "+ cks.size());
	driver.manage().deleteAllCookies();
	cks.clear();
	System.out.println(" Deleting all cookies");
	cks = driver.manage().getCookies();
	System.out.println(" No. of cookies  : "+ cks.size());
	
	// WebDriver Window Options
	Point wpos = driver.manage().window().getPosition();
	System.out.println("Position X  :" + wpos.getX());
	System.out.println( "Position Y  :" + wpos.getY());
	
	Dimension ws = driver.manage().window().getSize();
	System.out.println("Height  :" + ws.getHeight());
	System.out.println( "Width  :" + ws.getWidth());
	
	driver.manage().window().maximize();
	Thread.sleep(1000);
	//driver.manage().window().minimize();
	//Thread.sleep(1000);
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.manage().window().fullscreen();
	Thread.sleep(1000);
	driver.manage().window().maximize();
	Thread.sleep(1000);
	
	Point pos = new Point(50, 50);
	driver.manage().window().setPosition(pos);
	Thread.sleep(1000);
	Dimension wsze = new Dimension(500, 500);
	driver.manage().window().setSize(wsze);
	Thread.sleep(1000);
	
		driver.close();
	}
	
	public static void main(String[] args) throws Exception {
		WebDriverOptions obj = new WebDriverOptions();
		obj.browOps();
		
	}

}
