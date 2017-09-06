package com.bgee.base.reflect;

import com.bgee.base.util.common.FunUtil;

/**
 * 通过反射获知 继承的父类
 * @author bgee0915
 *
 */
public class ReflectDemo6 {
	public static void main(String[] args) {
		
		Class<?> classdemo6 = null;
		try {
			
			classdemo6 = Class.forName("com.bgee.base.reflect.Dog");
			Class<?> superClass = classdemo6.getSuperclass();
			FunUtil.println(superClass.getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
