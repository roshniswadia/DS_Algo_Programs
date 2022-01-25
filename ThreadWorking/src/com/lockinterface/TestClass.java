package com.lockinterface;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProducerConsumerImpl impl = new ProducerConsumerImpl();
		Producer p = new Producer(impl);
		Consumer c = new Consumer(impl);
		
		new Thread(p).start();
		new Thread(c).start();
	}

}
