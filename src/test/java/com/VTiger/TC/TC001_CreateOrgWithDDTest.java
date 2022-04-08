package com.VTiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.objectRepo.CreateNewOrgPage;
import com.objectRepo.HomePage;
import com.objectRepo.OrgINfoPAge;

public class TC001_CreateOrgWithDDTest extends BaseClass {

	@Test(groups = "regression")
	public void createorgwithDDTest() throws InterruptedException, IOException 
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrglink().click();

		OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
	//	orgINfoPAge.getCreateorgbtn().click();
		
		driverUtils.waitandclick(orgINfoPAge.getCreateorgbtn());

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
	}

	@Test(groups = "smoke")
	public void deleteOrgTest() throws InterruptedException, IOException {

		HomePage homePage= new HomePage(driver);
		homePage.getOrglink().click();

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
	}

}
