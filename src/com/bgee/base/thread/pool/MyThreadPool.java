package com.bgee.base.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
	public static void main(String[] args) {
//		创建等待队列
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(20);
		
//		线程中保存的线程数 包含空线程
//		线程池中允许的最大线程数
//		当线程数大于核心时，终止前多余的空线程等待新任务的最长时间
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(7,10,3,TimeUnit.MILLISECONDS,queue);;
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		pool.execute(new Thread(new MyThread()));
		
		pool.shutdown();
		
	}
	
	
	static class MyThread implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() +" ----> " + System.currentTimeMillis());
		}
	}
}
