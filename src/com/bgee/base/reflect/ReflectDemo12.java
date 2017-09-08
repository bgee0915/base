package com.bgee.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectDemo12 {
	public static void main(String[] args) {
		String name;
		if (args.length > 0){
			name = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			System.out.println("enter class name (e.g java.util.Date): ");
			name = in.next();
		}
		
		try {
			Class<?> c1 = Class.forName(name);
			Class<?> superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			if(modifiers.length() > 0) {
				System.out.println(modifiers + "");
			}
			System.out.println("class " + name);
			if (superc1 != null && superc1 != Object.class) {
				System.out.println(" extends " + superc1.getName());
			}
			System.out.println("\n{\n");
			printConstructors(c1);
			System.out.println();
			printMethods(c1);
			System.out.println();
			printFields(c1);
			System.out.println("}");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void printConstructors(Class<?> c1) {
		Constructor[] constructors = c1.getDeclaredConstructors();
		for(Constructor c : constructors) {
			String name = c.getName();
			System.out.println("  ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) {
				System.out.println(modifiers + "  ");
			}
			System.out.println(name + "(");
			
			Class []paramTypes = c.getParameterTypes();
			for(int j=0; j<paramTypes.length; j++) {
				
			}
		}
	}
	
	public static void printMethods(Class<?> c1) {
		
	}
	
	public static void printFields(Class<?> c1) {
		
	}
}
