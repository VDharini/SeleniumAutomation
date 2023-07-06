package advancedSrini.pom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
public WebDriver driver;
	
	public HomePage (WebDriver d) {
		driver = d;
	}

	@FindBy(xpath = "//input[@id = 'search']")
	WebElement searchInput;
	
	@FindBy(xpath = "//a[normalize-space(text())= 'Sign In']")
	WebElement signInLink;
	
	@FindBy(xpath = "//a[text() = 'Create an Account']")
	WebElement createActLink;
	
	/**
	 * Method to search a dress
	 * @param sStr   --- search string
	 * @return 
	 * @throws Exception
	 */
	
	public boolean search(String sStr) throws Exception {
		Thread.sleep(2000);
		if(!searchInput.isDisplayed()) {
			return false;
		}
		searchInput.click();
		searchInput.clear();
		searchInput.sendKeys(sStr);
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		return true;

		
	}
	
	/**
	 * Method to launch Sign in page from Home Page
	 * @throws Exception
	 */
	public void launchSignin() throws Exception {
		Thread.sleep(2000);
		signInLink.click();
		Thread.sleep(2000);
		
	}
	
	/**
	 * Method to launch Create an Account  from Home Page
	 * @throws Exception
	 */
	public void launchAccount() throws Exception {
		Thread.sleep(2000);
		createActLink.click();
		Thread.sleep(2000);
		
	}
	
}
