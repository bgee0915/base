package com.bgee.base.reflect;

import com.bgee.base.util.FunUtil;

/**
 * 反射实例化其它对象
 * @author bgee0915
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) {
		Man man = null;
		Class<?> manclass = null;
		
		try {
			manclass = Class.forName("com.bgee.base.reflect.Man");
			man = (Man)manclass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		man.setName("bgee0915");
		
		FunUtil.println(man);
	}
}

class Man{
	
//	为了反射实例化的安全 最好定义一个无参构造函数  因为如果有一个有参数的构造函数而没有显示的无参构造函数, 反射实例化会抛异常
	Man(){} 
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + "]";
	}
	
}
