package com.bgee.base.algorithm.sort;

import com.bgee.base.util.common.FunUtil;

/**
 * 选择排序
 * @author bgee0915
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int []a = {4,2,65,23,53,43,222,3,3,223};
		sort(a);
		for(Integer i : a) {
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int array[]) {
		int temp = 0;
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i] > array[j]) {
					FunUtil.swap(array, i, j);
				}
			}
		}
	}
}
