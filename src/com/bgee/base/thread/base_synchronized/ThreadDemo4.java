package com.bgee.base.thread.base_synchronized;

import java.util.HashSet;
import java.util.Set;

public class ThreadDemo4 {
	public static void main(String[] args) throws InterruptedException {
		
		Count count = new Count();
		ThreadTest test = null;
		Thread thread = null;
		for(int i=1; i<=30; i++) {
			test = new ThreadTest(String.valueOf(i),count);
			thread = new Thread(test,test.getName());
			thread.start();
		}
		
		Thread.sleep(1000);
		
		System.out.println(count.getSet().size());
		
	}
}


class ThreadTest implements Runnable{
	private Count count;
	private String name;
	
	ThreadTest(String name,Count count){
		this.name = name;
		this.count = count;
	}
	
	

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			int num = count.numAdd();
			count.getSet().add(num);
			System.out.println("线程-" + getName() + "   --- num = " + num);
		}
	}
	
	
	public String getName() {
		return this.name;
	}
}

class Count {
	private Set<Integer> set = new HashSet<Integer>();
	private int num = 0;
	
	public synchronized int numAdd() {
		return ++num;
	}
	
	public Set<Integer> getSet(){
		return this.set;
	}
}