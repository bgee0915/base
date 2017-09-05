package com.bgee.base.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.bgee.base.util.FunUtil;

/**
 * 打印类的所有方法  修饰符 + 返回类型 + 方法名 + 参数类型 + 参数 + 异常
 * @author bgee0915
 *
 */
public class ReflectDemo8 {
	public static void main(String[] args) {
		Class<?> classdemo8 = null;
		try {
			classdemo8 = Class.forName("com.bgee.base.reflect.WuMan");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Method []method = classdemo8.getMethods();
		
		for(int i=0; i<method.length; i++) {
			
//			修饰符 (public protected default private)
			int temp = method[i].getModifiers();
			
//			返回类型 (String, int, long ...)
			Class<?> returnType = method[i].getReturnType();
			
//			参数数组 (args1, args2 ...)
			Class<?> []parameterTypes = method[i].getParameterTypes();
			
			FunUtil.print(Modifier.toString(temp)," ",returnType.getName()," ", method[i].getName(), "(" );
			
//			如果数组长度为 < 0   直接continue;
			if(parameterTypes.length <= 0) {
				FunUtil.print(")","\n");
				continue;
			}
			
//			打印参数
			for(int j=0; j<parameterTypes.length; j++) {
				FunUtil.print(parameterTypes[j].getName()," args" + j);
				if(j < parameterTypes.length - 1) {
					FunUtil.print(" , ");
				}
			}
			
			FunUtil.print(")");
			
//			异常
			Class<?> []exception = method[i].getExceptionTypes();

			if(null == exception || exception.length <= 0) {
				FunUtil.print("\n");
				continue;
			}

//			打印异常
			for(int k=0; k<exception.length; k++) {
				FunUtil.print(" throws ", exception[k].getName());
			}
			
			FunUtil.print("\n");
			
			
		}
	}
}
