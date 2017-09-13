package com.bgee.base.thread.producer_consumer_problem.demo1;

/**
 * 消费者
 * @author bgee0915
 *
 */
public class Consumer implements Runnable{
	private int conNum;
	private Storage storage;
	
	public Consumer() {}
	
	public Consumer(Storage storage, int conNum) {
		this.storage = storage;
		this.conNum = conNum;
	}

	@Override
	public void run() {
		storage.consume(conNum);
	}
	
	public int getConNum() {
		return this.conNum;
	}
}
