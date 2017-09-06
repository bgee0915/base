package com.bgee.base.reflect;

import java.lang.reflect.Constructor;

import com.bgee.base.util.common.FunUtil;

public class ReflectDemo4 {
	public static void main(String[] args) {
		Class<?> wumanClass = null;
		WuMan wuman1 = null;
		WuMan wuman2 = null;
		WuMan wuman3 = null;
		WuMan wuman4 = null;
		
		try {
			wumanClass = Class.forName("com.bgee.base.reflect.WuMan");
			
//			栈  先进后出 
			Constructor<?> []cons = wumanClass.getDeclaredConstructors();
			
			FunUtil.println(cons[0],cons[1],cons[2],cons[3]);
			
			wuman1 = (WuMan) cons[0].newInstance(18);
			wuman2 = (WuMan) cons[1].newInstance("Mrs liu");
			wuman3 = (WuMan) cons[2].newInstance("Mrs liu",18);
			wuman4 = (WuMan) cons[3].newInstance();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FunUtil.println(wuman1,wuman2,wuman3,wuman4);
		
	}
}


class WuMan{
	WuMan(){}
	WuMan(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	WuMan(String name){
		this.name = name;
	}
	
	WuMan(int age){
		this.age = age;
	}
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "WuMan [name=" + name + ", age=" + age + "]";
	}
	
}
