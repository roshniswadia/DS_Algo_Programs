package com.pcwithqueue;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> sharedQueue;
	private int max_capacity;
	private int counter;

	public Consumer(Queue<Integer> queue, int max_capacity) {
		this.sharedQueue = queue;
		this.max_capacity = max_capacity;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.isEmpty()) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				int i = sharedQueue.poll();
				System.out.println("Consumed : " + i);
				sharedQueue.notify();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
