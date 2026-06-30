package com.threads.demo;

public class MyThread003 extends Thread {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
