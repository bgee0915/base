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
