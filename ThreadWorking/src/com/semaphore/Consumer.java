package com.semaphore;

public class Consumer implements Runnable {
	
	ProducerConsumerImpl impl;
	
	public Consumer(ProducerConsumerImpl impl) {
		this.impl = impl;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			impl.get();
		}

	}

}
