package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FutureDate {


	@Test
	public void futuredate() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/flights/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();

		driver.findElement(By.xpath("//li[@data-cy=\"account\"]")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();



		for (int i = 0; i <11 ; i++) 
		{

			try {
				driver.findElement(By.xpath("//div[@aria-label=\"Tue Jan 03 2023\"]")).click();
				break;

			} catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();

			}
		}


	}

}
