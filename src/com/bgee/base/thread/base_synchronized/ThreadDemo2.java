package com.bgee.base.thread.base_synchronized;


public class ThreadDemo2 implements Runnable{
	String name;
	private Calc calc;
	
	

	@Override
	public void run() {	
		int num = 0;
		for(int i=0; i<10; i++) {
			num = getCalc().numAdd();
		}
		System.out.println("thread-" + Thread.currentThread().getName() + "    ---  num=" + num);
	}
	
	
	
	ThreadDemo2(Calc calc,String name){
		this.name = name;
		this.calc = calc;
	}
	
	public Calc getCalc() {
		return this.calc;
	}
	
	
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		ThreadDemo2 threadDemo2 = null;
		for(int i=1; i<=10; i++) {
			threadDemo2 = new ThreadDemo2(calc,i+"");
			new Thread(threadDemo2).start();
		}
		
	}
}

class Calc{
	int num = 0;
	public synchronized  int numAdd() {
		return num+=2;
	}
}



