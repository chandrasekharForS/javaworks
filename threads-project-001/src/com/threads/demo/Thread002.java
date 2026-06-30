package com.threads.demo;

class MyThread002 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + 
				" is running.");
	}
	
}
public class Thread002 {
	public static void main(String[] args) {
		MyThread002 mt1 = new MyThread002();
		Thread t1 = new Thread(mt1);
		t1.setName("First");
		
		MyThread002 mt2 = new MyThread002();
		Thread t2 = new Thread(mt2);
		t2.setName("Second");
		
		
		MyThread002 mt3 = new MyThread002();
		Thread t3 = new Thread(mt3);
		t3.setName("Third");
		
		t1.start();
		t2.start();
		t3.start();

	}
}
