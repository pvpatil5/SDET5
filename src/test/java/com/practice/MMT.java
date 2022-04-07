package com.practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {

	@Test(dataProvider = "values")
	public void mmt(String src, String dest, String stop) {

		System.out.println(src);

		System.out.println(dest);

		System.out.println(stop);
		Date date = new Date();

		String s1=	date.toString();

		System.out.println(s1);

		// Tue Apr 05 13:14:21 IST 2022

		// 0   1    2    3       4  5

		String[] str = s1.split(" ");

		String date1=str[2];

		String day=str[0];

		String month = str[1];

		String year=str[5];

		String curtrentdate=day+" "+month+" "+date1+" "+year;

		System.out.println(curtrentdate);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/flights/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();

		driver.findElement(By.xpath("//li[@data-cy=\"account\"]")).click();

		driver.findElement(By.id("fromCity")).sendKeys(src);

		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();

		driver.findElement(By.id("toCity")).sendKeys(dest);

		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();

		String a=	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).getAttribute("title");

		driver.findElement(By.xpath("//div[@aria-label='"+curtrentdate+"']")).click();




	}

	@DataProvider
	public Object[][] values() 
	{

		Object arr[][] = new Object[3][3];

		arr[0][0]="BLR";
		arr[0][1]="HYD";
		arr[0][2]="HYD";

		arr[1][0]="BOM";
		arr[1][1]="PUN";
		arr[1][2]="HYD";

		arr[2][0]="HYD";
		arr[2][1]="DEL";
		arr[2][2]="CCU";


		return arr;



	}




}
