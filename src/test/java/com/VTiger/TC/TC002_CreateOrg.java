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
import com.generic.WebDriverUtils;
import com.objectRepo.CreateNewOrgPage;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;
import com.objectRepo.OrgINfoPAge;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg{

	@Test
	public void createorg() throws InterruptedException, IOException
	{
		PropFile_Util file_Util= new PropFile_Util();
		Fake_Data data = new Fake_Data();

		//login vtigercrm
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils= new WebDriverUtils(driver);
		driverUtils.pageloadtimeout();
		driverUtils.maximisewindow();

		driver.get(file_Util.readdatafrompropfile("url"));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp();
		
		HomePage homePage= new HomePage(driver);
		homePage.getOrglink().click();
		//Create New Organisation
		OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
		orgINfoPAge.getCreateorgbtn().click();

		CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getorgnametxtbox().sendKeys(orgname);

		newOrgPage.getSaveorgbtn().click();
		Thread.sleep(3000);

		homePage.getOrglink().click();
		
		orgINfoPAge.searchforOrg(orgname, "accountname");

		String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(actual_orgname.equals(orgname)) 
		{
			System.out.println("TC Passed");	
		}
		else {
			System.out.println("FAil");
		}	

		homePage.logoutfromApp();
		
		driverUtils.closeBrowser();
	}

}
