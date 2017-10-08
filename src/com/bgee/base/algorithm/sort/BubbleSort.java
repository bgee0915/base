package com.bgee.base.algorithm.sort;

import com.bgee.base.util.common.FunUtil;

/**
 * 冒泡排序: 下标相邻的两个数进行排序
 * @author bgee0915
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int []a = {999,23,124,1222,42,43,55,12,3234,21,4423,33,43,56,24,212,1,23,4,3};
		sort(a);
		for(Integer i : a) {
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int []array) {
		for(int i=0; i<array.length - 1; i++) {
			for(int j=0; j < array.length -1 - i; j++) {
				if(array[j] > array[j + 1]) {
					FunUtil.swap(array, j, j + 1);
				}
			}
		}
	}
}
