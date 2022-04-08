package com.VTiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.Fake_Data;
import com.objectRepo.ContactInfoPage;
import com.objectRepo.ContactOrg_popup;
import com.objectRepo.CreateContactPage;
import com.objectRepo.HomePage;

public class TC003_ContactWithOrgTest extends BaseClass
{
	@Test(groups = "integration")
	public void createcontactwithorgTest() throws InterruptedException, IOException 
	{
		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		contactInfoPage.getCreatecontactsimg().click();

		CreateContactPage  contactPage = new CreateContactPage(driver);

		Fake_Data fake_Data = new Fake_Data();
		String contactname=fake_Data.lastname();
		contactPage.getLastNameEdt().sendKeys(contactname);

		contactPage.getOrganizationLookUpImage().click();
		// window switching

		driverUtils.switchTowindow("Accounts");
		ContactOrg_popup org_popup = new ContactOrg_popup(driver);
		org_popup.searchandSelectforOrg("Mango");

		driverUtils.switchTowindow("Contact");

		contactPage.getSaveBtn().click();

		Thread.sleep(3000);
		homePage.getContactslink().click();

		//validation
		contactInfoPage.checkcontactcreated(contactname, "Last Name");

		Thread.sleep(3000);

		String fname=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();

		if(fname.equals(contactname)) {
			System.out.println("TC Pass");
		}
		else {
			System.out.println("TC Fail");
		}
	}

	@Test(groups="smoke")
	public void createcontact() throws InterruptedException, IOException
	{
		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		contactInfoPage.getCreatecontactsimg().click();

		CreateContactPage  contactPage = new CreateContactPage(driver);

		Fake_Data fake_Data = new Fake_Data();
		String contactname=fake_Data.lastname();
		contactPage.getLastNameEdt().sendKeys(contactname);
		
		contactPage.getSaveBtn().click();

		Thread.sleep(3000);
		homePage.getContactslink().click();

		contactInfoPage.checkcontactcreated(contactname, "Last Name");

		Thread.sleep(3000);

		String fname=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();

		if(fname.equals(contactname)) {
			System.out.println("TC Pass");
		}
		else {
			System.out.println("TC Fail");
		}
	}
}
