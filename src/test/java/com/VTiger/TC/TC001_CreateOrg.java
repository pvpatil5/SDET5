package com.VTiger.TC;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.generic.Fake_Data;
import com.generic.PropFile_Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOrg {

	@Test
	public void createorg() throws InterruptedException, IOException 
	{
		//login vtigercrm
		PropFile_Util propFile_Util = new PropFile_Util();
		Fake_Data data= new Fake_Data();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(propFile_Util.readdatafrompropfile("url"));

		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(propFile_Util.readdatafrompropfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(propFile_Util.readdatafrompropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//Create New Organisation with DD

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		String orgname=data.getOrgname();
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement wb=driver.findElement(By.name("industry"));
		Select s=new Select(wb);
		s.selectByValue("Chemicals");
		WebElement web1=driver.findElement(By.name("rating"));
		Select s1=new Select(web1);
		s1.selectByValue("Active");
		WebElement wb2=driver.findElement(By.name("accounttype"));
		Select s2=new Select(wb2);
		s2.selectByValue("Customer");
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);

		//Validation
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement ele=driver.findElement(By.id("bas_searchfield"));
		Select s3=new Select(ele);
		s3.selectByValue("accountname");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(actual_orgname.equals(orgname)) 
		{
			System.out.println("TC Passed");	
		}
		else {
			System.out.println("FAil");
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
