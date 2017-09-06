package com.bgee.base.reflect;


import com.bgee.base.util.common.FunUtil;

/**
 * 反射实例1 获取类全名
 * @author bgee0915
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		Class<?> demo1Class = demo1.getClass();
		
//		类的全路径名称
		String absoluteName = demo1Class.getName();
		
//		类名
		String className = demo1Class.getSimpleName();
		
		FunUtil.println(absoluteName,className);
		
	}
}

class Demo1{
	
}
