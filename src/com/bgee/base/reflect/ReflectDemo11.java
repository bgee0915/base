package com.bgee.base.reflect;

import java.lang.reflect.Method;

import com.bgee.base.util.FunUtil;

public class ReflectDemo11 {
	public static void main(String[] args) {
		Class<?> classdemo11 = null;
		try {
			classdemo11 = Class.forName("com.bgee.base.reflect.Dog");
			Object dogObj =  classdemo11.newInstance();
			
//			调用setName 方法
			Method setMethod = classdemo11.getMethod("setName", Class.forName("java.lang.String"));
			setMethod.invoke(dogObj, "请叫我陛下");
			
//			调用getName 方法
			Method getMethod = classdemo11.getMethod("getName");
			FunUtil.println(getMethod.invoke(dogObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
