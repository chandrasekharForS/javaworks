package com.threads.demo;

class MyThread extends Thread{
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + 
				" is running.");
	}
}
public class Thread001 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("First");
		MyThread t2 = new MyThread();
		t2.setName("Second");
		MyThread t3 = new MyThread();
		t3.setName("Third");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
