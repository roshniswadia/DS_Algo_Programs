package com.exception.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExceptionInCallable {

	public static void main(String[] args) {
		final ExecutorService exec = Executors.newFixedThreadPool(1);

		exec.submit(() -> {
			System.out.println("In Runnable Task");
			throw new RuntimeException("Runtime Exception");
		});

		// submit method will swallow the exception
		// execute will throw the exception
		final Future<Object> future = exec.submit(() -> {
			System.out.println("In Callable Task");
			throw new RuntimeException("Runtime Exception in Callable");
		});

		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();

		final ExecutorService executorService1 = new MonitoringThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		executorService1.execute(() -> {
			System.out.println("I will throw RuntimeException now.");
			throw new RuntimeException("Planned exception after execute()");
		});

		executorService1.shutdown();
	}
}
