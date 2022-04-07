package com.VTiger.TC;

import java.io.IOException;
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

import com.generic.Fake_Data;
import com.generic.PropFile_Util;
import com.generic.WebDriverUtils;
import com.objectRepo.ContactInfoPage;
import com.objectRepo.ContactOrg_popup;
import com.objectRepo.CreateContactPage;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_ContactWithOrg 
{
	@Test
	public void createcontactwithorg() throws InterruptedException, IOException 
	{

		//login vtigercrm
		Fake_Data data= new Fake_Data();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		LoginPage loginPage = new LoginPage(driver);
		driverUtils.maximisewindow();
		driverUtils.pageloadtimeout();

		PropFile_Util propFile_Util = new PropFile_Util();
		driver.get(propFile_Util.readdatafrompropfile("url"));

		loginPage.loginToApp();

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();
		// TC003 Start

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
		//logout vtigercrm

		homePage.logoutfromApp();

		driverUtils.closeBrowser();

	}
}
