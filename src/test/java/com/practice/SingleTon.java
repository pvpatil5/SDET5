package com.practice;

public class SingleTon 
{
	private static SingleTon singleTon;
	int age =5;
	String name="dog";

	public void single() {
		System.out.println("Single method");
	}

	private SingleTon() 
	{

	}
	public static SingleTon tonobjet() {
		singleTon = new SingleTon();
		return singleTon;
	}



}
