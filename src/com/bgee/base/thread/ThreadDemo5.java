package com.bgee.base.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo5 {
	
	private int num;
	private List<Thread> list = new ArrayList<Thread>();
	
	public ThreadDemo5(int num) {
		this.num = num;
	}
	
	public synchronized void numAdd() {
		
		Thread currThread = Thread.currentThread();
		Thread theThread = null;
		while(num < 75) {
			
			for(int i=0;i<5;i++) {
				num++;
				System.out.println(Thread.currentThread().getName() + ",  num=" + num);
			}
			
			
		}
		
		for(int j=0; j<3; j++) {
//			System.out.println("j= " + j + ", num=" + num + ", theThread=" + theThread.getName() + ", currThread=" + currThread.getName());
			theThread = getList().get(j);
			if (theThread == currThread) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				notifyAll();
			}
		}
		
	}
	
	public List<Thread> getList(){
		return this.list;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadDemo5 demo5 = new ThreadDemo5(0);
		Thread thread1 = new Thread(new ThreadRun(demo5));
		Thread thread2 = new Thread(new ThreadRun(demo5));
		Thread thread3 = new Thread(new ThreadRun(demo5));
		
		demo5.getList().add(thread1);
		demo5.getList().add(thread2);
		demo5.getList().add(thread3);
		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class ThreadRun implements Runnable {
	
	private ThreadDemo5 demo5;
	
	public ThreadRun(){}
	
	public ThreadRun(ThreadDemo5 demo5) {
		this.demo5 = demo5;
	}

	@Override
	public void run() {
		demo5.numAdd();
	}
}