package srinivasTestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotation {
	
	@Test(priority = 1, description="This is the first test case")
	public void testcase1() {
		System.out.println("Testcase 1 executed");
	}

	@Test(priority = 5, invocationCount=3)
	public void testcase3() {
		System.out.println("Testcase 3 executed");
	}
	
	@Test(priority = 3)
	public void testcase2() {
		System.out.println("Testcase 2 executed");
		//Assert.fail();
	}
	
	@Test(priority = 9)
	public void testcase5() {
		System.out.println("Testcase 5 executed");
		
	}
	@Test(priority = 7)
	public void testcase4() {
		System.out.println("Testcase 4 executed");
	}
	
}
