package advancedSrini.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
 WebDriver driver;
 
	public SignInPage(WebDriver d) {
		driver = d;
	}
	
	@FindBy(xpath = "//input[@id = 'email']")
	WebElement userInput;
	
	@FindBy(xpath = "//input[@id = 'pass']")
	WebElement pwdInput;
	
	@FindBy(xpath = "//button[@id = 'send2']")
	WebElement submitBtnt;
	
	/**
	 * Method to Sign in to the application
	 * @param uname
	 * @param pwd
	 * @return successful if empty, else failure message
	 * @throws Exception 
	 */
	public String login(String uname, String pwd) throws Exception {
		Thread.sleep(2000);
		if(!userInput.isDisplayed()) {
			return "Not found login username input";
		}
		userInput.sendKeys(uname);
		pwdInput.sendKeys(pwd);
		submitBtnt.click();
		Thread.sleep(2000);
		return " ";
	}
	
}
