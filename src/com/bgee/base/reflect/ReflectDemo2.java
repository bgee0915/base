package com.bgee.base.reflect;

import com.bgee.base.util.FunUtil;

/**
 * 实例化对象 的 三种方法
 * @author bgee0915
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) {
	
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		
		try {
			
//			实例化1 (推荐)
			demo1 = Class.forName("com.bgee.base.reflect.Demo2");
			
//			实例化2
			demo2 = Demo2.class;
			
//			实例化3
			demo3 = new Demo2().getClass();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		FunUtil.println("demo1: " + demo1.getName(),"demo2: " + demo2.getName(), "demo3: " + demo3.getName());
	}
}

class Demo2{
	
}
