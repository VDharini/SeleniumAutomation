package seleniumSrinivas;

import org.openqa.selenium.By;

public class UsingCSSLocator extends LaunchBrowser {

	public static void main(String[] args) throws Exception {
		
		UsingCSSLocator obj = new UsingCSSLocator();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.cssStrategy();
		}

	public void cssStrategy() {
		driver.findElement(By.linkText("Create an Account")).click();
		
		String fname = "input#firstname";  //Using Id
		driver.findElement(By.cssSelector(fname)).sendKeys("Dha");
		String signUp = "input.checkbox";  // Using class
		driver.findElement(By.cssSelector(signUp)).click();
		String ln = "input[title = 'Last Name']";  // Using non std attribute(title) use square braces
		driver.findElement(By.cssSelector(ln)).sendKeys("Var");

		driver.close();
		
		// input.input-text[title = 'Last Name']   ---- using class and title attributes
		// input.input-text[title = 'Last Name'][type = 'text']  ---- using class, type, and title attributes
		// input[title = 'Last Name'][type = 'text']  ---- using 2 attributes
		// input#lastnamet[title = 'Last Name']  ---- using id and title attributes
		// input#lastname.input-text  -- -- using class and id
		// input[title = \"Last Name\"]   ---- using double quotes for the value( but not recommended)
		
		// input[id^ = 'email_']   ------- ^ represents prefix (means id starts with email_)
		// input[id$ = '_address'']   ------- $ represents postfix (means id ends with _address)
		// input[id* = 'email']   ------- * represents anywhere similar to contains
		
		// Node Navigation
		//div>input.input-text -- ">" represents immediate child
		
		//div[class = 'field field-name-firstname required']>div>input.input-text --">"  represents immediate child
		
		//div[class = 'field field-name-firstname required'] input.input-text --"  "  space represents descendant
		
		//fieldset div[class = 'field field-name-firstname required'] input -- "  " space represents descendant(child
		
		//fieldset div[class = 'field field-name-firstname required']  label+div> input -- " + "  represents sibling
		//form[data-role='tocart-form'] input+input+input+button+input+input
		//form[data-role='tocart-form'] input:nth-child(6) - "nth child"
		
	}

}
