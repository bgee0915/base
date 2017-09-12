package com.bgee.base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 implements Runnable{
	String name;
	private Calc calc = new Calc();
	Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {

		for(int i=1; i<=10; i++) {
			new Thread(new ThreadDemo2(i+"")).start();
		}
		
	}

	@Override
	public void run() {	
		for(int i=0; i<10; i++) {
			calc.numAdd();
		}
		System.out.println("thread-" + Thread.currentThread().getName() + "    ---  num=" + Calc.num);
	}
	
	
	
	ThreadDemo2(String name){
		this.name = name;
	}
}

class Calc{
	static int num = 0;
	public void numAdd() {
		num+=2;
	}
	
}



