package com.pcwithqueue;

import java.util.LinkedList;
import java.util.Queue;

public class PCDemo {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		Producer prod = new Producer(queue, 10);
		Consumer con = new Consumer(queue, 10);
		
		prod.start();
		con.start();
	}

}
