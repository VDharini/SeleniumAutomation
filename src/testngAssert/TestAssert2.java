package testngAssert;

import org.testng.Assert;

public class TestAssert2 {

	public static void main(String[] args) {
		
		String title =  "Welcome to the world of automation";
		System.out.println("Program Starts");
		System.out.println("1 Executed");
		System.out.println("2 Executed");
		System.out.println("3 Executed");
		
		String actual = "Selenium123";
		Assert.assertTrue(title.contains("world"));
		
		System.out.println("4 Executed");
		System.out.println("5 Executed");
		System.out.println("Program Ends");
		
			}

}
