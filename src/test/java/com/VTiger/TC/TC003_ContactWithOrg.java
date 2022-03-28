package com.VTiger.TC;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_ContactWithOrg 
{
	@Test
	public void createcontactwithorg() throws InterruptedException 
	{
		//login vtigercrm
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// TC003 Start
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		WebElement salutationtype = driver.findElement(By.name("salutationtype"));

		Select select = new Select(salutationtype);
		select.selectByValue("Mr.");

		driver.findElement(By.name("firstname")).sendKeys("GHAN");
		driver.findElement(By.name("lastname")).sendKeys("SHYAM");

		// window switching
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentid =	it.next();

		String childid=	it.next();

		driver.switchTo().window(childid);

		driver.findElement(By.id("search_txt")).sendKeys("MANGO");

		driver.findElement(By.name("search")).click();

		Thread.sleep(5000);

		driver.findElement(By.id("1")).click();

		driver.switchTo().window(parentid);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//validation

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("GHAN");

		WebElement ddforcontacts=driver.findElement(By.id("bas_searchfield"));

		Select select1 = new Select(ddforcontacts);
		select1.selectByValue("firstname");
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);

		String fname=driver.findElement(By.xpath("//span[@vtfieldname='firstname']/..")).getText();

		if(fname.equals("GHAN")) {
			System.out.println("TC Pass");
		}
		else {
			System.out.println("TC Fail");
		}
		//logout vtigercrm
		WebElement ele1=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		WebElement ele2=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		act.moveToElement(ele2).perform();
		ele2.click();

		Thread.sleep(8000);
		driver.close();

	}
}
