package com;

/*We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  
Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)*/
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
