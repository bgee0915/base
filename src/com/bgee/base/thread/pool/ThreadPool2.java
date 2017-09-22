package com.bgee.base.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
	public static void main(String[] args) { 
		
//		创建一个线程池， 他可以安排在给定延迟后运行命令或者定期地执行。
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		
		Thread thread1 = new Thread(new ThreadTwo());
		Thread thread2 = new Thread(new ThreadTwo());
		Thread thread3 = new Thread(new ThreadTwo());
		Thread thread4 = new Thread(new ThreadTwo());
		Thread thread5 = new Thread(new ThreadTwo());
		
		pool.execute(thread1);
		pool.execute(thread2);
		pool.execute(thread3);
		
//		延迟
		pool.schedule(thread4,1220,TimeUnit.MILLISECONDS);
		pool.schedule(thread5,10,TimeUnit.MILLISECONDS);
		
		pool.shutdown();
	}
	
	static class ThreadTwo implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
