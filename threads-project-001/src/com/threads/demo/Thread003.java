package com.threads.demo;


public class Thread003 {

	public static void main(String[] args) {
		MyThread003 t1 = new MyThread003();
		t1.setName("First");
		
		MyThread003 t2 = new MyThread003();
		t2.setName("Second");
		
		MyThread003 t3 = new MyThread003();
		t3.setName("Third");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
