package com;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		
		int[] arr = {2,7,4,1,8,1};
		
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
		}

		while(!queue.isEmpty() && queue.size() > 1) {
			int firstEle = queue.poll();
			int secondEle = queue.poll();
			
			if(firstEle != secondEle) {
				int newElement = firstEle - secondEle;
				queue.add(newElement);
			}
		}
		
		if(queue.isEmpty()) {
			System.out.println("Weight is 0");
		}else {
			System.out.println("Weight is " + queue.peek());
		}
	}

}
