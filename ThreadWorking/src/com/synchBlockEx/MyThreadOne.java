package com.synchBlockEx;

public class MyThreadOne implements Runnable {

	TestClass t;

	public MyThreadOne(TestClass t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.testMethodOne();
		t.testMethodTwo();
		t.testStaticMethodOne();
		t.testStaticMethodTwo();
	}

}
