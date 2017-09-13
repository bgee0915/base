package com.bgee.base.thread.producer_consumer_problem.demo1;

/**
 * 生产者
 * @author bgee0915
 *
 */
public class Producer implements Runnable{
	
	private int proNum;
	private Storage storage;
	
	public Producer() {}
	
	public Producer(Storage storage, int proNum) {
		this.storage = storage;
		this.proNum = proNum;
	}

	@Override
	public void run() {
		storage.produce(proNum);
	}
}
