package com;

import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingAndRepeating missingAndRepeating = new MissingAndRepeating();
		int[] arr = {4, 3, 6, 2, 1, 1};
		String a = "Roshni";
		
	}
	
	public void findMissingAndRepeatingOne(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(countMap.containsKey(i)) {
				System.out.println("Repeating Char : " + arr[i] );
			}else {
				countMap.put(i, arr[i]);
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(countMap.get(i) == null) {
				System.out.println("Missing Element : " + i);
			}
		}
		
	}
	
	public void findMissingAndRepeatingTwo(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			
		}
	}

}
