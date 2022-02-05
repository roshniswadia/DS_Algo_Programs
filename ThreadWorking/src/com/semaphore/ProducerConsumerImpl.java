package com.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerImpl {

	Semaphore prodSemaphore = new Semaphore(1);
	Semaphore conSemaphore = new Semaphore(0);
	Queue<Integer> sharedQueue = new LinkedList<>();

	public int get() {
		int consumedVal = 0;
		try {
			conSemaphore.acquire();

			consumedVal = sharedQueue.poll();
			System.out.println("Consumed : " + consumedVal);
			prodSemaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return consumedVal;
	}

	public void put(int i) {

		try {
			prodSemaphore.acquire();
			sharedQueue.offer(i);
			System.out.println("Produced : " + i);
			conSemaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
