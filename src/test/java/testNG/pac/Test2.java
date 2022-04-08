package testNG.pac;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Test2 
{
	@Test()
	public void a()
	{
		System.out.println("a");
		Assert.assertEquals(true, false);

	}
	@Test()
	public void b()
	{
		System.out.println("b");
	}
//
//	@Test()
//	public void c()
//	{
//		System.out.println("c");
//	}
//	@Test()
//	public void d()
//	{
//		System.out.println("d");
//	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Beforemethod");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("After Method");
	}
}
