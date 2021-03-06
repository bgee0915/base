package com.bgee.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
				System.out.print(modifiers + "");
			}
			System.out.print("class " + name);
			if (superc1 != null && superc1 != Object.class) {
				System.out.println(" extends " + superc1.getName());
			}
			System.out.print("  {");
			printConstructors(c1);
			printMethods(c1);
			printFields(c1);
			System.out.println("}");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
		
		 
	}
	
	public static void printConstructors(Class<?> c1) {
		Constructor<?>[] constructors = c1.getDeclaredConstructors();
		for(Constructor<?> c : constructors) {
			String name = c.getName();
			System.out.println("  ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + "  ");
			}
			System.out.print(name + "(");
			
			Class<?> []paramTypes = c.getParameterTypes();
			for(int j=0; j<paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(",");
				}
				System.out.print(paramTypes[j].getName());
				
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class<?> c1) {
		Method []methods = c1.getDeclaredMethods();
		for(Method m : methods) {
			Class<?> returnType = m.getReturnType();
			String name = m.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + "  ");
				System.out.print(returnType.getName() + " " + name + "(");
			}
			
			Class<?> []paramTypes = m.getParameterTypes();
			for(int j=0; j<paramTypes.length; j++) {
				if(j > 0) {
					System.out.print(",");
				}
				System.out.println(paramTypes[j].getName());
			}
			
		}
	}
	
	public static void printFields(Class<?> c1) {
		Field []fields = c1.getDeclaredFields();
		for(Field f : fields) {
			Class<?> type = f.getType();
			String name = f.getName();
			System.out.print("  ");
			String modifier = Modifier.toString(f.getModifiers());
			if(modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
		
	}
}
