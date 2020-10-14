package com;

import java.util.HashMap;
import java.util.Map;

//Given an array containing only 0s and 1s, find the 
//largest subarray which contains equal no of 0s and 1s. Expected time complexity is O(n).
public class ContiguousSubArrayEqual01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 0, 0, 1, 1, 0, 1, 0, 0, 0, 1 };
		ContiguousSubArrayEqual01 obj = new ContiguousSubArrayEqual01();
		obj.SolutionTwo(arr);
		
	}
	
	public void SolutionOne(int[] arr) {
		int max_length = 0;
		int countZero = 0;
		int countOne = 0;
		int lengthSoFar = 0;

		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i; j < arr.length; j++) {

				if (arr[j] == 0)
					countZero++;
				else
					countOne++;
				lengthSoFar++;

				if (countZero == countOne && max_length < lengthSoFar) {
					max_length = lengthSoFar;
				}
			}
			
			countZero = 0;
			countOne = 0;
			lengthSoFar = 0;
		}

		System.out.println("Max lenght will be : " + max_length);
	}
	
	public void SolutionTwo(int[] arr) {
		
		int sum = 0;
		int max_length = 0;
		int length = 0;
		Map<Integer, Integer> indexSumMap = new HashMap<>();
		indexSumMap.put(0, -1); // { 0, 0, 1, 1, 0, 1, 0, 0, 0, 1 }
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i] == 0? -1:1; // {-1, -1, 1,1,-1,1, -1, -1, -1. 1}
		}
		
		for(int i=0; i<arr.length; i++) {// 0, 1,2,3
			sum = sum + arr[i]; // -1 , -2 , -1, 0
			
			if(sum == 0) {
				max_length = i + 1;
			}
			
			if(indexSumMap.containsKey(sum)) {
				length = i - indexSumMap.get(sum);
				if(max_length < length) {
					max_length = length;
				}
			}else{
				indexSumMap.put(sum, i); // (-1,2) (-2, 1) (0 , )
			}
		}
		
		System.out.println("Max Lenght : " + max_length);
		
	}

}
