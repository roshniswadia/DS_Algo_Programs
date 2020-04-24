package com.executorFwk;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		
		ScheduledFuture<String> future = (ScheduledFuture<String>) exec.schedule(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Called -------");
				return "scheduled";
			}
			
		}, 5, TimeUnit.SECONDS);
		
		exec.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Schduled at fixed rate");
				
			}
		}, 5, 5, TimeUnit.SECONDS);
		
		exec.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Schduled at fixed delay");
			}
		}, 10, 5, TimeUnit.SECONDS);

	}

}
