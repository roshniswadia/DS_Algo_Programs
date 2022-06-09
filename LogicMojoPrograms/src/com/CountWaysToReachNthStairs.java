package com;

public class CountWaysToReachNthStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numberOfSteps = 4;
		int arr[] = new int[numberOfSteps];
		arr[0] =1;
		arr[1] = 2;
		for(int i=2; i<numberOfSteps;i++) {
			arr[i] = arr[i-1] + arr[i-2]; 
		}
		
		System.out.println(arr[numberOfSteps -1]);

	}

}
