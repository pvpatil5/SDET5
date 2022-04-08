package testNG.pac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AllAnnotation 
{
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite executing");
	}

	@AfterSuite
	public void as() {
		System.out.println("After suite");
	}


	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");

	}

	@AfterClass
	public void afterClass()

	{
		System.out.println("after class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeClass
	public void beforeclass() 
	{
		System.out.println("Before Class");	
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("Beforemethod");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("After Method");
	}
}
