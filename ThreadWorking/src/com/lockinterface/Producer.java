package com.lockinterface;

import java.util.List;

public class Producer implements Runnable {
	
	ProducerConsumerImpl impl; 
	
	public Producer(ProducerConsumerImpl impl ) {
		this.impl = impl;
	}
	
	@Override
	public void run() {
		impl.produce();

	}

}
