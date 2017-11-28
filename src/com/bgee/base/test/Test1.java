package com.bgee.base.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReadWriteLock;


public class Test1 implements Callable<String>{
	public static void main(String[] args) {
 
	}

	@Override
	public String call() throws Exception {
		System.out.println("===  go === ");
		return "result";
	}
	
}
