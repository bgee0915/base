package com.bgee.base.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Test1 {
	public static void main(String[] args) {
		
//		java8 新特性  ,  join
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String splitStr = String.join(",",list);
		System.out.println(splitStr);
		
	}
}
