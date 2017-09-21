package com.bgee.base.thread.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadDemo8 {
	private static Semaphore a = new Semaphore(1);
	private static Semaphore b = new Semaphore(1);
	private static Semaphore c = new Semaphore(1);
	
	public static void main(String[] args) {
		try {
			b.acquire();
			c.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new ThreadAAA().start();
		new ThreadBBB().start();
		new ThreadCCC().start();
	}
	static class ThreadAAA extends Thread {
		public void run() {
			try {
				for(int i=0; i<10; i++) {
					a.acquire();
					System.out.println("A -- " + i);
					b.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadBBB extends Thread {
		public void run() {
			try {
				for(int i=0; i<10; i++) {
					b.acquire();
					System.out.println("B -- " + i);
					c.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ThreadCCC extends Thread {
		public void run() {
			try {
				for(int i=0; i<10; i++) {
					c.acquire();
					System.out.println("C -- " + i);
					a.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
