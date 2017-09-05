package com.bgee.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.bgee.base.util.FunUtil;

public class ReflectDemo9 {
	public static void main(String[] args) {
		Class<?> classdemo9 = null;
		try {
			classdemo9 = Class.forName("com.bgee.base.reflect.Dog");
			
//			属性 数组 // 该类的所有字段
			Field []f = classdemo9.getDeclaredFields();
			
			for(int i=0; i<f.length; i++) {
				
//				权限修饰符
				int modifierNum = f[i].getModifiers();
				String modifier = Modifier.toString(modifierNum);
				
//				属性类型
				String typeName = f[i].getType().getName();
				
				FunUtil.print(modifier," ", typeName, " " , f[i].getName() , "\n");
			}
			
			
			//所有的    自己的 或者 继承的父类 或者 实现的接口的 public 的 字段
			Field []superF = classdemo9.getFields();
			System.out.println(superF.length);
			for(int j=0; j<superF.length; j++) {
				int superModifierNum = superF[j].getModifiers();
				String superModifier = Modifier.toString(superModifierNum);
				
				String superTypeName = superF[j].getType().getName();
				
				FunUtil.print(superModifier," ", superTypeName," ", superF[j].getName(),"\n");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
