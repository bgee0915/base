package com.bgee.base.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {

	public static void main(String[] args) {
		
//		创建可重用固定线程数的线程池
//		ExecutorService pool = Executors.newFixedThreadPool(2);
		
//		创建一个使用单个 worker线程的 Executor，以无界队列方式来运行该线程
//		ExecutorService pool = Executors.newSingleThreadExecutor();
		
//		创建一个可以根据需要创建新线程的线程池， 但是在以前构造的线程可用时将重用他们
		ExecutorService pool = Executors.newCachedThreadPool();
		
		Thread thread1 = new Thread(new threadOne());
		Thread thread2 = new Thread(new threadOne());
		Thread thread3 = new Thread(new threadOne());
		Thread thread4 = new Thread(new threadOne());
		
		pool.execute(thread1);
		pool.execute(thread3);
		pool.execute(thread2);
		pool.execute(thread4);
		pool.shutdown();
	}
	
	
	static class threadOne implements Runnable{

		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " ----> ");
		}
		
	}
}


