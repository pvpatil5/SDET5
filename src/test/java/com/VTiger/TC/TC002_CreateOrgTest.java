package com.VTiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.objectRepo.CreateNewOrgPage;
import com.objectRepo.HomePage;
import com.objectRepo.OrgINfoPAge;

public class TC002_CreateOrgTest extends BaseClass{

	@Test(groups = "smoke")
	public void createorgTest() throws InterruptedException, IOException
	{
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

	}

	@Test(groups = "integration")
	public void createorgwithmobilenoTest() throws InterruptedException, IOException 
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrglink().click();
		//Create New Organisation
		OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
		orgINfoPAge.getCreateorgbtn().click();

		CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getorgnametxtbox().sendKeys(orgname);

		newOrgPage.getPhonenotxtbox().sendKeys(data.phonenumber());

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
	}

}
