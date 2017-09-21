package com.bgee.base.thread.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadDemo8 {
	private static Semaphore a = new Semaphore(1);
	private static Semaphore b = new Semaphore(1);
	private static Semaphore c = new Semaphore(1);
	
	
	static class ThreadAAA extends Thread {
		public void run() {
			
		}
	}
	
	static class ThreadBBB extends Thread {
		
	}
	
	static class ThreadCCC extends Thread {
		
	}
}
