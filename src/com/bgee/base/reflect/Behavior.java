package com.bgee.base.reflect;


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
		
	}
 
	@Override
	public void eat() {
		
	}
	
	@Override
	public void fuck() {
		
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
		return "Dog [age=" + age + ", name=" + name + "]";
	}

	
	
	
}