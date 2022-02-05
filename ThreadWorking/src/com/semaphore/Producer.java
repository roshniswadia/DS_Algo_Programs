package com.semaphore;

public class Producer implements Runnable {

	ProducerConsumerImpl impl;

	public Producer(ProducerConsumerImpl impl) {
		this.impl = impl;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			impl.put(i);
		}
	}

}
