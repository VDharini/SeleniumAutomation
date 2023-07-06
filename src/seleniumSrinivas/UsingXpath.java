package seleniumSrinivas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class UsingXpath extends LaunchBrowser{

	public static void main(String[] args) throws Exception {
		
		UsingXpath obj = new UsingXpath();
		obj.browserLaunch("chrome", "https://magento.softwaretestingboard.com/");
		obj.xpathDemo();
	}
	
		public void xpathDemo() {
			
			String sxpath = "//input[@id = 'search']";     //  in future if we make changes it's good to use variables
			
			//driver.findElement(By.xpath("//input[@id = 'c'])).sendKeys("T-Shirts") -- need to make changes in all places if we have to
			
			driver.findElement(By.xpath(sxpath)).sendKeys("T-Shirts");
			driver.findElement(By.xpath(sxpath)).sendKeys(Keys.ENTER);

			
			
			// /html/body/div[2]/header/div[2]/div[2]/form/div/div/input ---  absolute path
			
			// relative paths
			// input[@id = 'search']    ---- with one attribute
			// input[@id = 'search'] [@name = 'q']   ---- with two attributes
	
			//	String searchX = "//input[@id = 'c'][@name = 'q']" ;
			 // System.out.println(searchX);
			// input[ contains(@name, 'login')][@id = 'email ]  ---- using contains
			// input[ contains(@name, 'login') and (@id = 'email') ]  ---- using and & contains
			// input[ starts-with(@name, 'login') and (@id = 'email') ]  ---- using starts-with
			
			// input[ contains(@name, 'username') or (@id = 'email') ]  ---- using or & contains
			// input[ contains(@name, 'username') or (@id = 'email') and (@type = 'email') ]  ---- using or, and  & contains

			// a[text() = 'Create an Account']  ----- using text()
			// span[text() = 'Customer Login' ] --------------using text()
			// a[contains(text(), 'Sign In')] ------ using contains and text()
			// div[contains(text(), 'If you have an account')] ------ using partial text
			
			// a[normalize-space(text() = 'Sign In']  ------- normalize space --> to ignore the leading and 
													// trailing spaces
			// input[ contains(@name, 'login') and not (@id = 'pass') ]  ---- using not  & contains
			//input[not@id = 'pass') ]   ------- using not
			//input[not(contains(@type, 'text'') )]   ----- using not and contains
				
			//Without using any attributes we can identify the elements using parent child relationship
			
			//form[@id = 'search_mini_form']/div   ----div is the child to form (use single / to represent the child)
			//form[@id = 'search_mini_form']/child: :div  -----  : : standard notation to represent the child
			//form[@id = 'search_mini_form']/div/div/input  -- div-child , div- grand child, input - super grand child 
			//form[@id = 'search_mini_form']//input    --- use // to skip the hierarchy( from the above line  -- /div/div) -- short cut way
			//form[@id = 'search_mini_form']/descendant: :input   -- child represents child/grandchild/super grandchild -- down in the hierarchy
			//form[@id = 'search_mini_form']//input [@id = 'search']  -- we can use other attributes with descendant
			//form[@id = 'search_mini_form']//input[2]   --- we can use index also to uniquely identify 
			//form[@id = 'search_mini_form']/div[2]  ---/div[2] -- siblings use index to specify which child (index starts from 1 )
						
			//input[@id= 'firstname']/parent : :div  -- using immediate parent
			//input[@id= 'firstname']/parent : :div /../label/span[.='First Name'] ----   use  ..  to identify the immediate parent
			//input[@id= 'firstname']/ancestor: :form  --- to skip some immediate parents to go up in the ladder use ancestor
			
			//input[@id= 'firstname']//ancestor: :form//label/span[text() = 'First Name'] -- to go up and again down in the ladder 
			//fieldset[contains(@class,'fieldset')]/legend/following-sibling::div[2]   ----   following sibling --going down in the ladder
			//fieldset[contains(@class,'fieldset')]/div/preceding-sibling::legend/span  --- preceding sibling -- going up in the ladder
			
			//fieldset[contains(@class,'fieldset')]/preceding::div    --- up hierarchy
			//fieldset[contains(@class,'fieldset')]/following::div    ----- down hierarchy
			
			// preceding and following usually not recommended 
			
			//div[contains(@class,'field')]/*/input ---- any node(*)  -- anynode which has parent as div and child as input
			//div[contains(@class,'field')]/*/*[@name = 'email']  --- -*[ ]-- represents the node with the given attribute
			
			//*[@type = 'email'] / self::input[@name = 'email']   ---- using self
			
			// Dynamic Xpath
			//a[contains(text(), ‘Create an Account’)]			
			//a[contains(text(), ‘Sign In’)]	
			//a[contains(text(), ‘%r%’)]	— Dynamic Xpath – (mostly used to find the hyper links)
			//a[Normalize-space(text(), ‘%r%’)] — -to remove the leading and trailing spaces use normalize
			
			String linkx = "//a[normalize-space(text()) = ‘%r%’]";  // Dynamic Xpath
			
		    driver.findElement(By.xpath(linkx.replace("%r%", 	"Sign In"))).click();
			driver.findElement(By.xpath(linkx.replace("%r%", "Create an Account"))).click();

			
			}
		
	}
