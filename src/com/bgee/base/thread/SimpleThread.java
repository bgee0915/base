package com.bgee.base.thread;

import com.bgee.base.util.common.FunUtil;

/**
 * 多线程demo1
 * @author bgee0915
 *
 */
public class SimpleThread extends Thread{
	 private int countDown = 5;
	 private int threadNumber;
	 private static int threadCount = 0;
	 
	 public SimpleThread() {
		 threadNumber = ++threadCount;
		 System.out.println("marking " + threadNumber);
	 }
	 
	 public void run() {
		 while(true) {
			 System.out.println("Thread " + threadNumber + "(" + countDown + ")" );
			 if(--countDown == 0) {
				 return;
			 }
		 }
	 }
	 
	 public static void main(String[] args) {
		 for (int i=0; i<5; i++) {
			 new SimpleThread().start();
		 }
		 FunUtil.println("all thread start: ");
	 }
}
