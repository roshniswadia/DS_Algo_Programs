package com.synchBlockEx;

public class TestClass {

	public static synchronized void testStaticMethodOne() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Static Synch Method  One: " + i + " " + Thread.currentThread().getName());
		}
	}

	public void testStaticMethodTwo() {
		synchronized (TestClass.class) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Static Synch Method Two : " + i + " " + Thread.currentThread().getName());
			}
		}
	}

	public synchronized void testMethodOne() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Normal Synch Method One: " + i + " " + Thread.currentThread().getName());
		}
	}

	public synchronized void testMethodTwo() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Normal Synch Method Two: " + i + " " + Thread.currentThread().getName());
		}
	}

}
