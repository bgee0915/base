package com.bgee.base.generic;

import java.io.Serializable;

/**
 * 1： 	为泛型加上限定 ,  T 必须为 comparable(根据你的限定类而变化) 的子类型 
 * 2： 	如果有多个限定  则加上 & 连接
 * 3：	如果不给定限定, 则虚拟机编译时 原始类型 T 会被 Object 替换, 否则取第一个限定的类型 (此处为 Comparable)
 * 4：	为了提高效率, 一般将标签接口(没有方法的接口) 放在边界列表的末尾最后
 * 5：	虚拟机中没有泛型, 只有普通的方法和类
 * 6：	所有的类型参数都用他们的限定类型替换
 * 7：	泛型使用要考虑许多的限制, 大多都是由类型擦除引起的  (第五条)
 * 8： 	禁止使用带有类型变量的静态域方法
 * 9：	不能抛出或使用泛型类的实例, 泛型类 扩展 Throwable 亦是不合法的
 * 10：	
 * 
 *  
 *  
 * @author bgee0915
 *
 * @param <T>
 */
public class GenericDemo1<T extends Comparable<T> & Serializable> {

}
