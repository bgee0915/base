package com.bgee.base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 implements Runnable{
	String name;
	private static int num = 0;
	Lock lock = new ReentrantLock();
	

	
	public static void main(String[] args) {

		int j = 0;
		while(j++ < 5) {
			new Thread(new ThreadDemo2(j+"")).start();
		}		
		
	}

	@Override
	public void run() {	
		for(int i=0; i<20; i++) {
			numAdd();
		}
	}
	
	public void numAdd() {
		lock.lock();
			++num;
			System.out.println("thread" + this.name + " -  num:  " + num);
		lock.unlock();
	}
	
	ThreadDemo2(String name){
		this.name = name;
	}
}



