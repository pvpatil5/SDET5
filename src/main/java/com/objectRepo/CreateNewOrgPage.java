package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {

	WebDriver driver;


	public CreateNewOrgPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnametxtbox;

	@FindBy(name="industry")
	private WebElement industrydd;

	@FindBy(name="accounttype")
	private WebElement typedd;

	@FindBy(name="rating")
	private WebElement ratingdd;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveorgbtn;

	public WebElement getorgnametxtbox() {
		return orgnametxtbox;
	}

	public WebElement getIndustry() {
		return industrydd;
	}

	public WebElement getType() {
		return typedd;
	}

	public WebElement getRating() {
		return ratingdd;
	}

	public WebElement getSaveorgbtn() {
		return saveorgbtn;
	}
}
