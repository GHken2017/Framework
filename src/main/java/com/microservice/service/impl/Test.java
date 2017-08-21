package com.microservice.service.impl;

import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;
//	private String name;
//
//	private void set(String name){
//		this.name=name;
//	}
	
	@Override
	public void run() {
		synchronized(this){
			
		for (int j = 0; j < 10; j++) {
//			lock.lock();
//			try {
//				i++;
//				System.out.println(i);
//			} finally {
//				lock.unlock();
//			}
			i++;
			System.out.println(i);
		}
			
		
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("main");
	}

}
