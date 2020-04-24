package com.executorFwk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		
	/*	for(int i= 1; i< 8; i++) {
			MyThreadOne r = new MyThreadOne();
			executor.execute(r);
		}*/
		
		MyThreadTwo sumThread = new MyThreadTwo();
		
		Future<String> result = executor.submit(sumThread);
		
		if(result.isDone()) {
			String sum = result.get();
			System.out.println("Sum of ten numbers : " + sum);
		}
	}

}
