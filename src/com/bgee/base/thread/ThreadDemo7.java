package com.bgee.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo7 {
	static Lock lock = new ReentrantLock();
	static int num = 0;
	static Condition a = lock.newCondition();
	static Condition b = lock.newCondition();
	static Condition c = lock.newCondition();
	
	static class ThreadAA extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for(int i=0; i<10; i++) {
					while(num % 3 != 0) {
						a.await();
					}
					System.out.println("A -- num=" + num);
					num ++ ;
					b.signal();
				}
				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadBB extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for(int i=0; i<10; i++) {
					while(num % 3 != 1) {
						b.await();
					}
					System.out.println("B -- num=" + num);
					num++;
					c.signal();
				}
				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadCC extends Thread{
		
		@Override
		public void run() {
			try {
				lock.lock();
				for(int i=0; i<10; i++) {
					while(num % 3 != 2) {
						c.await();
					}
					System.out.println("C -- num=" + num);
					num++;
					a.signal();
				}
				lock.unlock();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ThreadAA().start();
		new ThreadBB().start();
		new ThreadCC().start();
	}	
}
