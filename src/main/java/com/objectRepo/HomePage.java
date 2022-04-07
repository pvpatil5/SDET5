package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebDriverUtils;

public class HomePage  //Rule 1
{
	WebDriver driver;
	//Rule 2 : Locate all the elements by using @findby,@findbys and @findAll annotation

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglink;

	//Rule 3: Create constructor for initilization of webelements
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Rule 4 : Generate getters to access the webelements
	public WebElement getOrglink() {
		return orglink;
	}
	
	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement logoutimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutbtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;

	
	public WebElement getContactslink() {
		return contactslink;
	}

	//Rule 5: Business Library
	public void logoutfromApp() 
	{
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		driverUtils.movetoElement(logoutimg);
		driverUtils.movetoElement(logoutbtn);
		logoutbtn.click();
	}

}
