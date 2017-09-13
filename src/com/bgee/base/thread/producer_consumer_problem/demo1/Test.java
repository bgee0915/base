package com.bgee.base.thread.producer_consumer_problem.demo1;

public class Test {
	public static void main(String[] args) {
		Storage storage = new Storage(0);
		
		Producer producer1 = new Producer(storage,10);
		Producer producer2 = new Producer(storage,20);
		Producer producer3 = new Producer(storage,30);
		Producer producer4 = new Producer(storage,40);
		Producer producer5 = new Producer(storage,50);
		
		Consumer consumer1 = new Consumer(storage,50);
		Consumer consumer2 = new Consumer(storage,40);
		Consumer consumer3 = new Consumer(storage,30);
		Consumer consumer4 = new Consumer(storage,20);
		Consumer consumer5 = new Consumer(storage,10);
		Consumer consumer6 = new Consumer(storage,5);
		
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(producer4).start();
		new Thread(producer5).start();
		new Thread(consumer1).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		new Thread(consumer4).start();
		new Thread(consumer5).start();
		new Thread(consumer6).start();
		
	}
}
