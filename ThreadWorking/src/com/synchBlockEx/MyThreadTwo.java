package com.synchBlockEx;

public class MyThreadTwo implements Runnable {

	TestClass t;

	public MyThreadTwo(TestClass t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.testMethodOne();
		t.testMethodTwo();
		TestClass.testStaticMethodOne();
		t.testStaticMethodTwo();
	}

}
