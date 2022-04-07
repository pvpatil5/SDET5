package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebDriverUtils;

public class OrgINfoPAge 
{
	WebDriver driver;
	public OrgINfoPAge (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgbtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchfororgtxtbox;
	
	@FindBy(id ="bas_searchfield")
	private WebElement orgtypedd;
	
	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}

	public WebElement getSearchfororgtxtbox() {
		return searchfororgtxtbox;
	}

	public WebElement getOrgtypedd() {
		return orgtypedd;
	}

	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}

	@FindBy(name="submit")
	private WebElement searchorgbtn;
	
	public void searchforOrg(String orgname, String value) {
		getSearchfororgtxtbox().sendKeys(orgname);
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		driverUtils.selectValuefromDD(getOrgtypedd(), value);
		getSearchorgbtn().click();
	}

}
