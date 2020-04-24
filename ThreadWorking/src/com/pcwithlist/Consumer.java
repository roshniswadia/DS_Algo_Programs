package com.pcwithlist;

import java.util.LinkedList;

public class Consumer extends Thread {

	public LinkedList<Integer> sharedList;
	public int max_capacity;

	public Consumer(LinkedList<Integer> sharedList, int capacity) {
		this.sharedList = sharedList;
		this.max_capacity = capacity;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (sharedList) {
				while (sharedList.isEmpty()) {
					try {
						sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int i = sharedList.removeFirst();
				System.out.println("Consumed : " + i);
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
