package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotationDemo {
		
		@BeforeSuite
		public void setUpReport()
		{
			System.out.println("Setting Up extent report");
		}
		@AfterSuite
		public void clearReport()
		{
			System.out.println("Clear the report");
		}
		@BeforeTest
		public void preTest()
		{
			System.out.println("Check if the application is Up");
		}
		@AfterTest
		public void postTest()
		{
			System.out.println("Get the Status code");
		}
		
		@BeforeClass
		public void clearCache()
		{
			System.out.println("Clear the Cache");
		}
		
		@AfterClass
		public void afterClass()
		{
			System.out.println("Collect the class from the memory");
		}
		@BeforeMethod
		public void setup()
		{
			System.out.println("Open the browser");
		}
		
		@AfterMethod
		public void tearDown()
		{
			System.out.println("Close the browser");
		}
		@Test( enabled = true , priority = 1)
		public void b()
		{
			System.err.println("Test 1 Executed");
		}
		
		@Test( enabled = true, priority = 2)
		public void a()
		{
			System.err.println("Test 2 Executed");
		}
		@Test( enabled = true , invocationCount = 1, priority = 3)
		public void c()
		{
			System.err.println("Test 3 Executed");
		}
}
