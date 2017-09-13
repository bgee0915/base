package com.bgee.base.thread.producer_consumer_problem.demo1;


/**
 * 简单的  生产者消费者模式  
 * @author bgee0915
 *
 */
public class Test {
	public static void main(String[] args) {
		Storage storage = new Storage(0);
		
		new Thread(new Producer(storage,10)).start();
		new Thread(new Producer(storage,20)).start();
		new Thread(new Producer(storage,30)).start();
		new Thread(new Producer(storage,40)).start();
		new Thread(new Producer(storage,50)).start();
		new Thread(new Producer(storage,20)).start();
		
		new Thread(new Consumer(storage,50)).start();
		new Thread(new Consumer(storage,40)).start();
		new Thread(new Consumer(storage,30)).start();
		new Thread(new Consumer(storage,20)).start();
		new Thread(new Consumer(storage,10)).start();
		new Thread(new Consumer(storage,5)).start();
		
	}
}
