package com.executorFwk;

public class MyThreadOne implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<=10; i++) {
		System.out.println("Executing "+ i + " : " + Thread.currentThread().getName());
		}
		
	}

}
