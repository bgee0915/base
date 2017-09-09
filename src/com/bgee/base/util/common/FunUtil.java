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
	
	/**
	 * 判空
	 * @param str
	 * @return
	 */
	public static boolean blank(String str) {
		if(null == str || 1 > str.length() || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
