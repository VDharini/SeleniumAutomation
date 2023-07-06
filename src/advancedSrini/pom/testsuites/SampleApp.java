package advancedSrini.pom.testsuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import advancedSrini.pom.pages.CreateAccount;
import advancedSrini.pom.pages.HomePage;
import advancedSrini.pom.pages.SignInPage;



public class SampleApp {
	public WebDriver driver;
	public String btype = "chrome";
	public String url = "https://magento.softwaretestingboard.com/";

	public HomePage homepage;
	public SignInPage signInPage;
	public CreateAccount createAcct;

	@BeforeClass
	public void launchBrowser() {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Create Objects
		homepage = PageFactory.initElements(driver, HomePage.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		createAcct = PageFactory.initElements(driver, CreateAccount.class);
	}
	@Test
	public void searchDress() throws Exception {
	boolean flag =	homepage.search("T-Shirts");
		Assert.assertTrue(flag, "Failed to search the dress");
		}
	@Test
	public void signInApp() throws Exception {
		homepage.launchSignin();
		Thread.sleep(2000);
		String retval = signInPage.login("roni_cost@example.com", "roni_cost3@example.com");
		Assert.assertFalse(retval.isEmpty(), retval);
		}
	@Test
	public void createAnAccount() throws Exception {
		homepage.launchAccount();
		boolean flag = createAcct.create();
		Assert.assertTrue(flag, "Failed to create account");
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	
	
}
