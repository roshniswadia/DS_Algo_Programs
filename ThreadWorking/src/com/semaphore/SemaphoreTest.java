package com.semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		
		ProducerConsumerImpl impl = new ProducerConsumerImpl();
		Producer p = new Producer(impl);
		Consumer c = new Consumer(impl);
		
		new Thread(p).start();
		new Thread(c).start();
		
		
	}

}
