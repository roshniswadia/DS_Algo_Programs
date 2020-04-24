package com;

public class MoveAllZeroesToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,0,2,3,0,0,0,2};
		
		int count =0;
		
		for(int i= 0; i< arr.length; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < arr.length) {
			arr[count++] = 0;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
