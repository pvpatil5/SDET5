package com.generic;

import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class Fake_Data
{

	/**
	 * @author AMAR-G
	 * This method generate random number till 1000
	 * @return int random number
	 */
	public int getRandomNumber() {
		Random random = new  Random();
		return	random.nextInt(1000);
	}
	/**
	 * This method generate frist name
	 * @return
	 */
	public String fristname() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}


	public String lastname() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}


	public String getOrgname() {
		Faker faker = new Faker();
		return faker.company().industry();
	}



	public String phonenumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getTodaysDate() {
		Date date = new Date();
		return date.toString();
		
		
	}
}
