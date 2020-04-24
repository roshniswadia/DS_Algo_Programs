package com.synchBlockEx;

public class ThreadDemo {

	public static void main(String[] args) {
		TestClass newT = new TestClass();

		Thread t1 = new Thread(new MyThreadOne(newT));
		Thread t2 = new Thread(new MyThreadTwo(newT));

		t1.start();
		t2.start();
	}

}
