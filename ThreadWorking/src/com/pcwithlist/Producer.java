package com.pcwithlist;

import java.util.LinkedList;

public class Producer extends Thread {

	public LinkedList<Integer> sharedList;
	public int max_capacity;
	public int counter = 1;

	public Producer(LinkedList<Integer> sharedList, int capacity) {
		this.sharedList = sharedList;
		this.max_capacity = capacity;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (sharedList) {
				while (sharedList.size() == max_capacity) {
					try {
						sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sharedList.add(counter);
				System.out.println("Produced : " + counter);
				counter++;
				sharedList.notify();
				
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
