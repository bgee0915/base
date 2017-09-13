package com.bgee.base.thread.producer_consumer_problem.demo1;

/**
 * 仓储
 * @author bgee0915
 *
 */
public class Storage {
//	仓储最大存储量
	public static final int MAX_NUM = 100;
	
//	当前库存量
	private int currentNum = 0;
	
	public Storage(){}
	
	public Storage(int currentNum){
		this.currentNum = currentNum;
	}
	
//	生产 num
	public synchronized void produce(int num) {
		while(num + currentNum > MAX_NUM) {
			System.out.println("将超过仓储最大存储量 , 不生产, 当前库存量： " + currentNum + " -- 需要生产量: " + num);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		currentNum += num;
		System.out.println("生产 -" + num + ", 当前库存量 - " + currentNum);
		notifyAll();
	}
	
	
//	消费 num
	public synchronized void consume(int num) {
		while(num > currentNum) {
			System.out.println("仓储存储量将不足 , 不支持消费, 当前库存量： " + currentNum + " -- 需要消费量: " + num);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		currentNum -= num;
		System.out.println("消费 -" + num + ", 当前库存量 - " + currentNum);
	}
	
	
	public int getCurrentNum() {
		return this.currentNum;
	}
	
	
}
