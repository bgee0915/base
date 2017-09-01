package com.bgee.base.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1： 	为泛型加上限定 ,  T 必须为 Comparable(根据你的限定类而变化) 的子类型 
 * 2： 	如果有多个限定  则加上 & 连接
 * 3：	如果不给定限定, 则虚拟机编译时 原始类型 T 会被 Object 替换, 否则取第一个限定的类型 (此处为 Comparable)
 * 4：	为了提高效率, 一般将标签接口(没有方法的接口) 放在边界列表的末尾最后
 * 5：	虚拟机中没有泛型, 只有普通的方法和类
 * 6：	所有的类型参数都用他们的限定类型替换
 * 7：	泛型使用要考虑许多的限制, 大多都是由类型擦除引起的  (第五条)
 * 8： 	禁止使用带有类型变量的静态域方法
 * 9：	不能抛出或使用泛型类的实例
 * 10:	创建泛型数组是非法的  (Cannot create a generic array of ArrayList<xxx>)
 * 11：	上边界  <? extends Fruit>	必须为 Fruit 的子类型
 * 12:	下边界 <? super Banana>	必须为 Banana 的父类型
 * 
 * 12:  如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
		如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
		如果既要存又要取，那么就不要使用任何通配符。
		
 * 13：	数组和泛型不能很好地混合使用
 *  
 *  
 *  
 * @author bgee0915
 *
 * @param <T>
 */
public class GenericDemo1<T extends Comparable<T> & Serializable> {

	public static void main(String[] args) {
		
//		ok
		List<Object> list = new ArrayList<>();
		list.add(new Fruit());
		
//		上界
		List<? extends Fruit> upList = new ArrayList<>();
		upList.add(null);  //ok
//		upList.add(new Fruit());  	// boom!
//		upList.add(new Apple());	// boom!
//		upList.add(new Banana());	// boom!
		Fruit fruit = upList.get(0);
		
//		下界
		List<? super Banana> downList = new ArrayList<>();
		downList.add(new RedBanana());
		downList.add(new Banana());
//		downList.add(new Fruit()); 			// boom!
		
//		Banana banana = downList.get(0);	// boom!
		
		
		List<?> nList = new ArrayList<>();
//		nList.add("a");					// boom!
//		String zero = nList.get(0);		// boom! 
		
		
//		List<String> []arrayGeneric = new ArrayList<String>[10];	// boom!
	}
	
}


class Fruit{}

class Apple extends Fruit{}

class Banana extends Fruit{}

class RedBanana extends Banana{}

class Stack<E>{
	private E[] elements;
	
	private int size = 0;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 20;
	
	public Stack() {
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void ensureCapacity() {
		if(elements.length >= size) {
			elements = Arrays.copyOf(elements, size * 2 + 1);
		}
	}
	
	public void push(E obj) {
		ensureCapacity();
		elements[size++] = obj;
	}
	
	public E pop() {
		if(0 == size) {
			return null;
		}
		
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
}

















