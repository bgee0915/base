package com.bgee.base.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 
 * @author bgee0915
 *
 */
public class ThreadDemo6 {
	private static int num;
	private Lock lock = new ReentrantLock();
	
	ThreadDemo6(){}
	ThreadDemo6(int num, Lock lock){
		ThreadDemo6.num = num;
		this.lock = lock;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		ThreadDemo6.num = num;
	}
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		ThreadDemo6 thread = new ThreadDemo6(0,lock);
		new Thread(new ThreadA(thread)).start();
		new Thread(new ThreadB(thread)).start();
		new Thread(new ThreadC(thread)).start();
	}
	
	
	
}

class ThreadA implements Runnable {
	
	private ThreadDemo6 thread;
	
	ThreadA(){}
	ThreadA(ThreadDemo6 thread){
		this.thread = thread;
	}

	@Override
	public void run() {
		for(int i=0; i<10; ) {
			thread.getLock().lock();
			if(thread.getNum() % 3 == 0) {
				System.out.println("A -- " + thread.getNum());
				thread.setNum(thread.getNum() + 1);
				i++;
			}
			thread.getLock().unlock();
		}
	}
}

class ThreadB implements Runnable {
	
	private ThreadDemo6 thread;
	
	ThreadB(){}
	ThreadB(ThreadDemo6 thread){
		this.thread = thread;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; ) {
			thread.getLock().lock();
			if(thread.getNum() % 3 == 1) {
				System.out.println("B -- " + thread.getNum());
				thread.setNum(thread.getNum() + 1);
				i++;
			}
			thread.getLock().unlock();
		}
	}
}

class ThreadC implements Runnable {
	
	private ThreadDemo6 thread;
	
	ThreadC(){}
	ThreadC(ThreadDemo6 thread){
		this.thread = thread;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10;) {
			thread.getLock().lock();
			if(thread.getNum() % 3 == 2) {
				System.out.println("C -- " + thread.getNum());
				thread.setNum(thread.getNum() + 1);
				i++;
			}
			thread.getLock().unlock();
		}
	}
}

