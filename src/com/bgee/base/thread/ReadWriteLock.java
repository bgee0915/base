package com.bgee.base.thread;

/**
 * 读写锁
 * @author bgee0915
 *
 */
public class ReadWriteLock {
	private int reader = 0;
	private int writer = 0;
	private int requestWrite = 0;

	public synchronized void lockRead() throws InterruptedException {
		if(writer > 0 || requestWrite > 0) {
			wait();
		}
		reader++;
	}
	
	public synchronized void unlockRead() {
		reader--;
		notifyAll();
	}
	
	public synchronized void lockWrite() throws InterruptedException {
		requestWrite++;
		if(reader > 0 || writer > 0) {
			wait();
		}
		requestWrite--;
		writer++;
		
	}
	
	public synchronized void unlockWrite() {
		writer--;
		notifyAll();
	}
}
