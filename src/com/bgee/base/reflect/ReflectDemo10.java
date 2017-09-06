package com.bgee.base.reflect;

import java.lang.reflect.Method;

/**
 * 利用反射 invoke 方法 来调用其它类中的 方法 
 * @author bgee0915
 *
 */
public class ReflectDemo10 {
	public static void main(String[] args) {
		Class<?> classdemo10 = null;
		try {
			
			classdemo10 = Class.forName("com.bgee.base.reflect.Dog");
			 
//			"run" :  Dog类的 方法名
			Method methodRun = classdemo10.getMethod("run");
			methodRun.invoke(classdemo10.newInstance());
			
//			"see" 								:	Dog类的方法名
//			Class.forName("java.lang.String")	:	"see" 方法的参数的类型
//			" his master "						:	"see" 方法的参数
//			classdemo10.newInstance()			:	Dog 类的 实例化对象
			
			Method methodSee = classdemo10.getMethod("see",Class.forName("java.lang.String"));
			methodSee.invoke(classdemo10.newInstance(),  " his master ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
