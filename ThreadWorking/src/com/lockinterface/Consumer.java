package com.lockinterface;

public class Consumer implements Runnable {
	
	ProducerConsumerImpl impl; 
	
	public Consumer(ProducerConsumerImpl impl) {
		this.impl = impl;
	}

	@Override
	public void run() {
		impl.consume();

	}

}
