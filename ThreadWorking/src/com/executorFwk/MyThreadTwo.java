package com.executorFwk;

import java.util.concurrent.Callable;

public class MyThreadTwo implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("In thread");
		int sum = 0;
		for(int i =0; i<10; i++) {
			sum = sum + i;
			System.out.println("Sum :" + sum);
		}
		return "Hello Sum is:" + sum;
	}

}
