package testNG.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listners1.class )
public class Validations 
{
	WebDriver driver;
	public	static WebDriver sdriver;

	@Test
	public void login() 
	{
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		sdriver=driver;

		driver.get("http://localhost:8888");

		String title=	driver.getTitle();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("12345");

		driver.findElement(By.id("submitButton"));

		Assert.assertEquals(false, true);




	}

	
	@Test
	public void sample() 
	{
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		sdriver=driver;

		driver.get("http://localhost:8888");

		String title=	driver.getTitle();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("12345");

		driver.findElement(By.id("submitButton"));

		Assert.assertEquals(false, true);




	}
	@Test
	public void login1() 
	{
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		sdriver=driver;

		driver.get("httpS://FACEBOOK.COM");

		String title=	driver.getTitle();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("12345");

		driver.findElement(By.id("submitButton"));

		Assert.assertEquals(true, false);
	}

}
