package com.millisecondExec;

import java.time.Instant;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DemoThread implements Runnable {

	private CyclicBarrier barrier;
	
	public DemoThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			barrier.await();
			System.out.println(Instant.now().toEpochMilli());
			//System.out.println(System.currentTimeMillis());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
