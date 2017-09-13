package com.bgee.base.thread.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * 读写锁
 * @author bgee0915
 *
 */
public class ReadWriteLock {
	
	private Map<Thread,Integer> readingThreads = new HashMap<Thread,Integer>();
	private int writeAccess = 0;
	private int writeRequests = 0;
	private Thread writingThread = null;

	public synchronized void lockRead() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		while(!canGrantReadAccess(callingThread)) {
			wait();
		}
		readingThreads.put(callingThread, getReadAccessCount(callingThread) + 1);
	}
	
	public synchronized void unlockRead() {
		Thread callingThread = Thread.currentThread();
		
		if(!isReader(callingThread)) {
			throw new IllegalMonitorStateException("Calling thread does not hold a read lock on this ReadWriteLock");
		}
		
		int num = getReadAccessCount(callingThread);
		if(1 == num) {
			readingThreads.remove(callingThread);
			return;
		}
		
		readingThreads.put(callingThread,num + 1);
		notifyAll();
	}
	
	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		Thread currentThread = Thread.currentThread();
		while(!canGrantWriteAccess(currentThread)) {
			wait();
		}
		writeRequests--;
		writeAccess++;
		writingThread = currentThread;
	}
	
	public synchronized void unlockWrite() {
		if(!isWriter(Thread.currentThread())) {
			throw new IllegalMonitorStateException("Calling thread does not hold the write lock on this ReadWriteLock");
		}
		writeAccess--;
		if(writeAccess == 0) {
			writingThread = null;
		}
		notifyAll();
	}
	
	private int getReadAccessCount(Thread callingThreads) {
		Integer num = readingThreads.get(callingThreads);
		if(null == num) {
			return 0;
		}
		return num.intValue();
	}
	
	private boolean canGrantWriteAccess(Thread callingThread) {
		if(isOnlyReader(callingThread)) {
			return true;
		}
		if(hasReaders()) {
			return false;
		}
		if(!hasWriter()) {
			return true;
		}
		if(!isWriter(callingThread)) {
			return false;
		}
		return true;
	}
	
	private boolean canGrantReadAccess(Thread callingThread) {
		if(hasWriter()) {
			return false;
		}
		if(hasWriteRequests()) {
			return false;
		}
		if(isWriter(callingThread)) {
			return true;
		}
		if(isReader(callingThread)) {
			return true;
		}
		return true;
	}
	
	private boolean hasReaders() {
		return readingThreads.size() > 0;
	}
	
	private boolean isReader(Thread callingThread) {
		return readingThreads.get(callingThread) != null;
	}
	
	private boolean isOnlyReader(Thread callingThread) {
		return readingThreads.size() > 1 && readingThreads.get(callingThread) != null;
	}
	
	private boolean hasWriter() {
		return writingThread != null;
	}
	
	private boolean isWriter(Thread callingThread) {
		return writingThread == callingThread; 
	}
	
	private boolean hasWriteRequests() {
		return this.writeRequests > 0;
	}
}
