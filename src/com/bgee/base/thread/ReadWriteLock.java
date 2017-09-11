package com.bgee.base.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 读写锁
 * @author bgee0915
 *
 */
public class ReadWriteLock {
	
	private Map<Thread,Integer> readingThreads = new HashMap<Thread,Integer>();
	private int writer = 0;
	private int requestWrite = 0;

	public synchronized void lockRead() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		while(!canGrantReadAccess(callingThread)) {
			wait();
		}
		readingThreads.put(callingThread, getReadAccessCount(callingThread) + 1);
	}
	
	public synchronized void unlockRead() {
		Thread callingThread = Thread.currentThread();
		int num = getReadAccessCount(callingThread);
		if(1 == num) {
			readingThreads.remove(callingThread);
			return;
		}
		
		readingThreads.put(callingThread,num + 1);
		notifyAll();
	}
	
	public synchronized void lockWrite() throws InterruptedException {
//		requestWrite++;
//		if(reader > 0 || writer > 0) {
//			wait();
//		}
//		requestWrite--;
//		writer++;
		
	}
	
	public synchronized void unlockWrite() {
		writer--;
		notifyAll();
	}
	
	
	
	private int getReadAccessCount(Thread callingThreads) {
		Integer num = readingThreads.get(callingThreads);
		if(null == num) {
			return 0;
		}
		return num.intValue();
	}
	
	private boolean canGrantReadAccess(Thread callingThreads) {
		if(writer > 0) {
			return false;
		}
		
		if(requestWrite > 0) {
			return false;
		}
		
		if(!isReader(callingThreads)) {
			return false;
		}
		
		return true;
	}
	
	private boolean isReader(Thread callingThread) {
		return readingThreads.get(callingThread) != null;
	}
}
