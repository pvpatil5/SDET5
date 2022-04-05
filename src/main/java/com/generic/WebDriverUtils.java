package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils 
{
	WebDriver driver;




	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * @author AMAR-G
	 * This method will wait unless and until webpage is loaded or not.
	 * if loaded in given time then control will go to next line 
	 * 
	 */
	public void pageloadtimeout() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * @author AMAR-G
	 * This method will maximise the window
	 * 	 */

	public void maximisewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @author AMAR-G
	 * This method slecting value from DD
	 * this method will ony work when tagname is select
	 * @param element
	 * @param value
	 */
	public void selectValuefromDD(WebElement element,String value) 
	{
		Select select = new Select(element);
		select.selectByValue(value);

	}
	/**
	 * @author AMAR-G
	 * This method will select value from DD base4d on INdex Value
	 * @param element
	 * @param index
	 */


	public void selectbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}
	/**
	 * this method is selecting text from DD based on Visible text
	 * @param text
	 * @param element
	 */
	public void selectbyvisibleText(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This methos is going to do mouse hover
	 * @param target
	 */
	public void movetoElement(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();

	}
	/**
	 * @author AMAR-G
	 * This method will close the browser
	 */
	public void closeBrowser() {
		driver.close();
	}

}
