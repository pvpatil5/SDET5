package com.practice;

public class Demo {

	public static void main(String[] args) {
		SingleTon objectofsingleton = SingleTon.tonobjet();
		int age=objectofsingleton.age;
		objectofsingleton.single();
		String name=objectofsingleton.name;
	}

}
