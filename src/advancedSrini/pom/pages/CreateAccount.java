package advancedSrini.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount {
	public WebDriver driver;
	
	public CreateAccount(WebDriver driver) {
				this.driver = driver;
	}

	@FindBy(xpath = "//input[@id = 'firstname']")
	WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@id = 'lastname']")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@id = 'email_address']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@id = 'password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id = 'password-confirmation']")
	WebElement passwordconfInput;
	
	@FindBy(xpath = "//button[@title= 'Create an Account']")
	WebElement submitBtnt;
	
	/**
	 * Method to create an account
	 * @throws Exception
	 */
	public boolean create() throws Exception {
		
		firstNameInput.sendKeys("test");
		lastNameInput.sendKeys("test1");
		emailInput.sendKeys("test1@test.com");
		passwordInput.sendKeys("Test1!123");
		Thread.sleep(2000);
		passwordconfInput.sendKeys("Test1!123");
		Thread.sleep(2000);
		submitBtnt.click();
		return true;
		

	}
}
