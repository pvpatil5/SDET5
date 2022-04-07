package com.objectRepo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.PropFile_Util;

public class LoginPage 		//Rule 1: Class name should be PAgename
{
	WebDriver driver;
	//Rule 2 : Locate all the emenets by using @findby, @findbys and @findAll annotation and make the web elements as private

	@FindBy(name="user_name")
	private WebElement usernametxtbox;

	@FindBy(name="user_password")
	private WebElement passwordtxtbox;

	@FindBy(id="submitButton")
	private WebElement loginbtn;

	//Rule 4: Provide Getters for access

	public WebElement getUsernametxtbox() {
		return usernametxtbox;
	}

	public WebElement getPasswordtxtbox() {
		return passwordtxtbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	//Rule 3: Use constructor for initilization of webelements
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void loginToApp() throws IOException {
		PropFile_Util propFile_Util = new PropFile_Util();
		getUsernametxtbox().sendKeys(propFile_Util.readdatafrompropfile("username"));
		getPasswordtxtbox().sendKeys(propFile_Util.readdatafrompropfile("password"));
		getLoginbtn().click();
	}


}
