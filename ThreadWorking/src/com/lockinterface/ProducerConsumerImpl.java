package com.lockinterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {

	private static final int CAPACITY = 10;
	Queue<Integer> sharedQueue = new LinkedList<>();
	Random random = new Random();

	private final Lock lock = new ReentrantLock();
	private final Condition queueEmptyCondition = lock.newCondition();
	private final Condition queueFullCondition = lock.newCondition();

	public void produce() {
		lock.lock();
		try {
			while (sharedQueue.size() == CAPACITY) {
				System.out.println("Queue is Full");
				queueFullCondition.await();
			}
			sharedQueue.add(random.nextInt());
			System.out.println("Message added in the queue");
			queueEmptyCondition.signalAll();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void consume() {
		lock.lock();
		try {
			while (sharedQueue.isEmpty()) {
				System.out.println("Queue is Empty");
				queueEmptyCondition.await();
			}

			System.out.println("Consumed " + sharedQueue.poll());
			queueFullCondition.signalAll();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}

	}

}
