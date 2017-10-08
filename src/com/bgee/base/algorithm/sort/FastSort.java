package com.bgee.base.algorithm.sort;

/**
 * 快速排序
 * @author bgee0915
 *
 */
public class FastSort {
	public static void main(String[] args){
        int []a = {152,3,489,159,117,555,666,0,15,15,152,134,9};
        int low = 0;
        int height = a.length - 1;
        sort(a,low,height);
        for(Integer i : a){
            System.out.print(i + " ");
        }
    }

    public static void sort(int []a, int low, int height){

    	// 开始位
        int start = low;
        // 末尾位
        int end = height;
        // 基准值
        int key = a[low];
        
        while(end > start){
        	
            while(end > start && a[end] >= key){
                end--;
            }
            
            if(a[end] <= key){
            	swap(a,start,end);
            }


            while(end > start && a[start] <= key){
                start++;
            }
            if(key <= a[start]){
            	swap(a,start,end);
            }
        }
        if(start > low){
            sort(a,low,start-1);
        }
        if(end < height){
        	System.out.println("end: " + end + ",  height: " + height);
            sort(a,end+1,height);
        }
    }
    
    public static void swap(int []array, int a,int b) {
    	int temp = 0;
    	temp = array[a];
    	array[a] = array[b];
    	array[b] = temp;
    }
}
