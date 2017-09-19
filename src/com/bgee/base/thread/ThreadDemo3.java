package com.bgee.base.thread;


/**
 *  thread.join()   demo
 * @author lx
 *
 */
public class ThreadDemo3 implements Runnable{
	private String name;
	
	public ThreadDemo3(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		System.out.println(getName() + " - 线程开始运行:  ");
		for(int i=0; i<10; i++) {
			System.out.println("线程" + getName() + " value<" + i + ">");
		}
		System.out.println(getName() + " - 线程结束运行:  ");
		
	}


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " - 线程开始运行： ");
		ThreadDemo3 demoA = new ThreadDemo3("A");
		ThreadDemo3 demoB = new ThreadDemo3("B");

		System.out.println("main A");
		
		Thread threadA = new Thread(demoA);
		Thread threadB = new Thread(demoB);
		threadA.start();
		threadB.start();
		System.out.println("main B");
		
		threadB.join();
		System.out.println("main C");
		System.out.println(Thread.currentThread().getName() + " - 线程结束运行： ");
		
//		从多次运行结果来看,  只有当 B 线程结束了  主线程才会结束 .   A线程 并没有相关顺序关系
		
	}
}
