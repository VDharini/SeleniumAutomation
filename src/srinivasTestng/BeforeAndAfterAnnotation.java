package srinivasTestng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterAnnotation {
	
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite executed");
		//Assert.fail();   -- it will skip all the classes
	}
	
	@AfterSuite
	public void as() {
		System.out.println("After suite executed");
		//Assert.fail(); -
		} 
	
	@BeforeTest
	public void bt() {
		System.out.println("Before test executed");
		//Assert.fail();   -- it will skip all the classes
	}
	
	@AfterTest
	public void at() {
		System.out.println("After test executed");
		//Assert.fail(); -
		} 
	
	@BeforeClass
	public void bc() {
		System.out.println("Before Class execution");
		//Assert.fail();   -- it will skip all the test methods
	}
	
	@AfterClass
	public void ac() {
		System.out.println("After Class execution");
		//Assert.fail(); -- since it's after class it won't skip the test methods execution
	} 
	
	@BeforeMethod
	public void bm() {
		System.out.println("Before Method execution");
		//Assert.fail();   -- it will skip all the test methods
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After Method execution");
		//Assert.fail();  --- execute the first method and the rest will be skipped
	}
	
	@Test(priority = 1)
	public void launchBrowser() {
		System.out.println("Testcase 1 executed");
	}
	
	@Test(priority = 3)
	public void search() {
		System.out.println("Testcase 2 executed");
		//Assert.fail();
	}
	@Test(priority = 5)
	public void addToCart() {
		System.out.println("Testcase 3 executed");
	}
	
	@Test(priority = 7)
	public void purchase() {
		System.out.println("Testcase 4 executed");
	}
	
	@Test(priority = 9)
	public void closeBrowser() {
		System.out.println("Testcase 5 executed");
		
	}
	
	
}
