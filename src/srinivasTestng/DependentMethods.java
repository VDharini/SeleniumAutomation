package srinivasTestng;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DependentMethods {
	
	@BeforeSuite
	public void bsDM() {
		System.out.println("Before Suite for  Dependent method executed");
		//Assert.fail();   -- it will skip all the classes
	}
	@Test(priority = 1)
	public void launchBrowser() {
		System.out.println("Testcase to launch the browser");
		//Assert.fail();
	}
	
	@Test(priority = 3, dependsOnMethods={"launchBrowser"}, alwaysRun=true )
	// alwaysRun runs irrespective of the failure
	public void search() {
		System.out.println("Testcase for search");
	}
	
	@Test(priority = 5, dependsOnMethods={"launchBrowser", "search"})  
	//add curl braces to include more than one dependent method
	public void addToCart() {
		System.out.println("Testcase for add to cart");
		}
	
	@Test(priority = 7, timeOut=3000)
	public void purchase() {
		System.out.println("Testcase for purchase");
	}
	
	@Test(priority = 9)
	public void closeBrowser() {
		System.out.println("Testcase to close the browser");
	}
}
