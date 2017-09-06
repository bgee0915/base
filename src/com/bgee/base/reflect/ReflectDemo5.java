package com.bgee.base.reflect;

import com.bgee.base.util.common.FunUtil;

/**
 * 通过反射获知实现的接口   
 * @author bgee0915
 *
 */
public class ReflectDemo5 {
	public static void main(String[] args) {
		Class<?> classdemo5 = null;
		
		try {
			classdemo5 = Class.forName("com.bgee.base.reflect.Dog");
			Class<?> []intersArray = classdemo5.getInterfaces();
			
			for(int i=0; i<intersArray.length; i++) {
				FunUtil.println(intersArray[i],intersArray[i].getName());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
