package com.bgee.base.algorithm.sort;

import com.bgee.base.util.common.FunUtil;

/**
 * 选择排序:  依次固定每个下标，让每个固定下标中的数和后面所有的数据进行比较
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
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i] > array[j]) {
					FunUtil.swap(array, i, j);
				}
			}
		}
	}
}
