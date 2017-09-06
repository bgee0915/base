package com.bgee.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import com.bgee.base.util.common.FunUtil;

/**
 * 获取构造函数的参数及类型
 * @author bgee0915
 *
 */
public class ReflectDemo7 {
	public static void main(String[] args) {
		
		Class<?> classdemo7 = null;
		
		try {
			classdemo7 = Class.forName("com.bgee.base.reflect.WuMan");
			Constructor<?> []cons = classdemo7.getDeclaredConstructors();
			for(int i=0; i<cons.length; i++) {
				
//				FunUtil.println(cons[i]);
				
				Class<?> []pt = cons[i].getParameterTypes();
				Parameter []p = cons[i].getParameters();
				
				
				FunUtil.println("=========================↓");
				for(int j=0; j<pt.length; j++) {
					FunUtil.print(pt[j],",");
				}
				FunUtil.println("\n=========================↑\n");
				
				
				FunUtil.println("-------------------------↓");
				for(int k=0; k<p.length; k++) {
					FunUtil.print("p[k]= ",p[k],"\np[k].getName()=",p[k].getName(),",");
				}
				FunUtil.println("\n-------------------------↑\n");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
