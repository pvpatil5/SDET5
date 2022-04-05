package com.practice;

public class ThisKeyword2 {

	
	public static void main(String[] args) {
	
		String a ="Hyderabad";
		String b = "Telangana";
		
		ThisKeyword keyword = new ThisKeyword(a, b);
		
		System.out.println(keyword.cityname+"  "+ keyword.statename);

	}

}
