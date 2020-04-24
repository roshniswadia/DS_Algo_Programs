package com;

import java.util.HashSet;
import java.util.Set;

public class ArrayPairWithGivenSum {

	public static void main(String[] args) {

		int[] arr = {0, -1, 2, -3, 1, -1};
		int sum = -2;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			int temp = sum - arr[i];
			
			if(set.contains(temp)) {
				System.out.println("Pair " + arr[i] + " : " + temp);
			}else {
				set.add(arr[i]);
			}
		}
	}

}
