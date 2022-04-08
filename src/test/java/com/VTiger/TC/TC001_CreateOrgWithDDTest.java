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

public class TC001_CreateOrgWithDDTest {

	@Test()
	public void createorgwithDDTest() throws InterruptedException, IOException 
	{
		//login vtigercrm
		Fake_Data data= new Fake_Data();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		LoginPage loginPage = new LoginPage(driver);

		driverUtils.pageloadtimeout();
		
		PropFile_Util propFile_Util = new PropFile_Util();
		driver.get(propFile_Util.readdatafrompropfile("url"));

		driverUtils.maximisewindow();

		loginPage.loginToApp();

		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
		orgINfoPAge.getCreateorgbtn().click();

		CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getorgnametxtbox().sendKeys(orgname);

		driverUtils.selectValuefromDD(newOrgPage.getIndustry(), "Chemicals");
		driverUtils.selectValuefromDD(newOrgPage.getRating(), "Active");
		driverUtils.selectValuefromDD(newOrgPage.getType(), "Customer");

		newOrgPage.getSaveorgbtn().click();
		Thread.sleep(3000);

		homePage.getOrglink().click();
		
		orgINfoPAge.searchforOrg(orgname, "accountname");
		
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

		homePage.logoutfromApp();
		
		driverUtils.closeBrowser();

	}
	
	@Test
	public void deleteOrgTest() throws InterruptedException, IOException {
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
		
		Thread.sleep(3000);
		
		orgINfoPAge.getFirstcheckbox().click();
		
		orgINfoPAge.getDeletebtn().click();
		
		driverUtils.acceptAlert();
		
		driverUtils.waitforelement(orgINfoPAge.getnoOrgfound());
		
		String msg= orgINfoPAge.getnoOrgfound().getText();

		
		if(msg.equals("No Organization Found !")) 
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
