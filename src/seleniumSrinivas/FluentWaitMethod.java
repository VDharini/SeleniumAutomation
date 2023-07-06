package seleniumSrinivas;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitMethod {

	public WebDriver driver;
	public String btype = "chrome";
	public String url = "https://magento.softwaretestingboard.com/";

	public void FluWaitDemo() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./browsersexe\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./browsersexe\\geckodriver.exe");

		if (btype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (btype.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		WebElement searchEle = applyFluentWait(driver, 15, 3, "//input[@id ='search']");
		searchEle.sendKeys("T-Shirts");
		Thread.sleep(2000);
		
		WebElement createEle = applyFluentWait(driver, 30, 5, "//a[text() = 'Create an Account']");
		createEle.click();
		Thread.sleep(2000);
		
		driver.close();
	}
		
		
		public static void main(String[] args) throws Exception  {
			FluentWaitMethod obj = new FluentWaitMethod();
			obj.FluWaitDemo();
			}
	
	public WebElement applyFluentWait(WebDriver driver, long timeout, long pollingtime, String eleXpath)  {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(timeout))
									.pollingEvery(Duration.ofSeconds(pollingtime))
									.ignoring(Exception.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(eleXpath));
				return element;
			}
		});
		return element;
	}
}