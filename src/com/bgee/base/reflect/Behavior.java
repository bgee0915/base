package com.bgee.base.reflect;

import com.bgee.base.util.FunUtil;

public  interface Behavior {
	public static final String fieldOne = "1";
	void sleep();
	void eat();
}


abstract class Animal{
	String name;
	int age;
	public String fatherField;
	
	abstract void fuck();
}

class Dog extends Animal implements Behavior {
	
	@Override
	public void sleep() {
		FunUtil.println("dog sleep");
	}
 
	@Override
	public void eat() {
		FunUtil.println("dog eat");
		
	}
	
	@Override
	public void fuck() {
		FunUtil.println("dog fuck");
		
	}
	
	Dog(){}
	
	Dog(String name, int age){
		this.name = name;
		this.age = age;
	}

	
	public int thisField;
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [thisField=" + thisField + ", age=" + age + ", name=" + name + "]";
	}
	
	
	public void run() {
		FunUtil.println("dog run");
	}
	
	public String see(String something) {
		FunUtil.println("dog see " + something);
		return something;
	}
}