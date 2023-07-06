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

public class FluentWaitDemo {

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

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath("//input[@id ='search']"));
				return element;
			}
		});

		Thread.sleep(2000);
		element.sendKeys("T-Shirts");

		WebElement we = (WebElement) wait.until(driver -> {
			return driver.findElement(By.xpath("//a[text() = 'Create an Account']"));
		});

		we.click();
		Thread.sleep(2000);

		driver.close();

	}

	public static void main(String[] args) throws Exception {

		FluentWaitDemo obj = new FluentWaitDemo();
		obj.FluWaitDemo();
	}
}