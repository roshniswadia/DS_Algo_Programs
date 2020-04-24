package com.pcwithlist;

import java.util.LinkedList;

public class PCWithList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> sharedList = new LinkedList<>();
		int max_capacity = 5;

		Producer t1 = new Producer(sharedList, max_capacity);
		Consumer t2 = new Consumer(sharedList, max_capacity);
		
		t1.start();
		t2.start();
	}

}
