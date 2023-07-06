package srinivasTestng;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoggingTxtXml {

		public WebDriver driver;
		String btype = "chrome";
		String url = "https://magento.softwaretestingboard.com/";
		
		Logger log;    // Declaration
		
		@BeforeMethod
		public void bm(Method m) throws Exception {
			// 1. Creating logger object
			//String fname = "C:\\Users\\dhari\\OneDrive\\Desktop\\JAVA\\Logger"+m.getName() + " .log";
			// you can use either log or txt extension both are in the text format
			//String fname = "C:\\Users\\dhari\\OneDrive\\Desktop\\JAVA\\Logger"+m.getName() + " .txt";
			String fname = "C:\\Users\\dhari\\OneDrive\\Desktop\\JAVA\\Logger"+m.getName() + " .xml";
			log = Logger.getLogger(fname);
			
			// 2. Set the level
			//log.setLevel(Level.ALL);   // all levels will be printed
			log.setLevel(Level.INFO);  // only levels upto info will be printed (severe,warning and info)
			
			
			//3. Handlers -- Handlers helps us to transform the info from program to file
			FileHandler handler = new FileHandler(fname);
			log.addHandler(handler);
			
			//4.Formatter -- done through handlers
			//SimpleFormatter formatter = new SimpleFormatter();
			//handler.setFormatter(formatter);
			
			// to use XML formatter(use .xml file)
			XMLFormatter formatter = new XMLFormatter();
			handler.setFormatter(formatter);
		}
	
		@AfterMethod
		public void am() {
			// Release log lock
		Handler[ ] harr = log.getHandlers();
		for(Handler han:harr) {
			han.close();
		}
		}
		@Test(priority = 1)
		public void launchBrowser() {
							
			log.severe("This is my sample severe message");
			log.warning("This is my sample warning message");
			log.info("This is my sample info message");
			log.config("This is my sample config message");
			log.fine("This is my sample fine message");
			log.finer("This is my sample finer message");
			log.finest("This is my sample finest message");
			
			
			
			System.setProperty("webdriver.chrome.driver", "./browsersexe\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "./browsersexe\\geckodriver.exe");

			if (btype.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (btype.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

			driver.get(url);
			log.info("Browser launched and navigated successfully");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Wait time set up successfully");
			
		}
		@Test(priority = 3)
		public void searchDress() throws Exception {
			try{
				Thread.sleep(2000);
			log.info("Entering Search string");
			String sxpath = "//input[@id = 'search']";     //  in future if we make changes it's good to use variables
			
			driver.findElement(By.xpath(sxpath)).sendKeys("T-Shirts");
			driver.findElement(By.xpath(sxpath)).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			log.info("Search successful");
			}	catch(Exception e) {
				log.severe(e.getMessage());
			}
			}
		
		@Test(priority = 5)
		public void closeBrowser() {
			log.info("Closing the browsers");
			driver.quit();
			log.info("Browser closed successfully");
		}
	}
