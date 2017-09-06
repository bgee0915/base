package com.bgee.base.util.common;

public class FunUtil {
	
	
	public static void println(Object ...objs) {
		if(objs != null && objs.length > 0) {
			for(Object o : objs) {
				System.out.println(o);
			}
		}
	}
	
	public static void print(Object ...objs) {
		if(objs != null && objs.length > 0) {
			for(Object o : objs) {
				System.out.print(o);
			}
		}
	}
}
