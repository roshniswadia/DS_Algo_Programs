package com.millisecondExec;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	private static final int THREAD_COUNT = 10;
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for(int i=0;i<THREAD_COUNT;i++) {
            executorService.execute(() -> {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
	}

}
