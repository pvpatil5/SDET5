package com.practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	@Test
	public void launchbrowser() 
	{
		Random random = new Random();
		System.out.println(	random.nextInt(1000));
	}
}
