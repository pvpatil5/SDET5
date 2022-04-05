package com.practice;

public class ThisKeyword 
{
	String cityname;
	String statename;

	public ThisKeyword(String cityname, String statename) {

		this(5);
		this.cityname = cityname;
		this.statename = statename;


	}
	public ThisKeyword(int a) {

		System.out.println("New constructor");

	}





}
