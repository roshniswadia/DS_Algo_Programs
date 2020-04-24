package com.pcwithqueue;

import java.util.Queue;

public class Producer extends Thread {
	private Queue<Integer> sharedQueue;
	private int max_capacity;
	private int counter;

	public Producer(Queue<Integer> queue, int max_capacity) {
		this.sharedQueue = queue;
		this.max_capacity = max_capacity;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.size() == max_capacity) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				sharedQueue.add(counter);
				System.out.println("Produced : " + counter);
				counter++;
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
