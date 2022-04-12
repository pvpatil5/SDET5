package com.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public Fake_Data data= new Fake_Data();
	public WebDriverUtils driverUtils;
	public WebDriver driver;
	public static WebDriver sdriver;
	public HomePage homePage;
	PropFile_Util propFile_Util = new PropFile_Util();

	@BeforeSuite(groups= {"smoke","integration","regression"})
	public void beforesuite() 
	{
		System.out.println("Connection to DB");
	}

	@AfterSuite(groups= {"smoke","integration","regression"})
	public void afterSuite() 
	{
		System.out.println("Dis-Connect from DB");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","integration","regression"})
	public void beforeclass(String BROWSER) throws IOException
	{
		//	String BROWSER=propFile_Util.readdatafrompropfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		sdriver=driver;
		driverUtils = new WebDriverUtils(driver);

	}

	@AfterClass(groups= {"smoke","integration","regression"})
	public void afterClass() throws InterruptedException {
		driverUtils.closeBrowser();
	}

	@BeforeMethod(groups= {"smoke","integration","regression"})
	public void logintoVtiger() throws IOException {
		LoginPage loginPage = new LoginPage(driver);

		driverUtils.pageloadtimeout();


		driver.get(propFile_Util.readdatafrompropfile("url"));

		driverUtils.maximisewindow();

		loginPage.loginToApp();
	}

	@AfterMethod(groups= {"smoke","integration","regression"})
	public void logout() {
		homePage= new HomePage(driver);
		homePage.logoutfromApp();
	}
}
