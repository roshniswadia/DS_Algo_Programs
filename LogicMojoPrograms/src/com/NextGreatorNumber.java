package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Write an algorithm to find out next greater number to given number with the same set of digits Asked in*/
public class NextGreatorNumber {

	public static void main(String[] args) {
		// 218765 //534976
		List<Integer> num = new ArrayList<>();
		num.add(2);
		num.add(1);
		num.add(8);
		num.add(7);
		num.add(6);
		num.add(5);

		int i = num.size() - 1;
		while (i > 0 && num.get(i - 1) > num.get(i)) {
			i--;
		}
		if (i == 0) {
			Collections.reverse(num);
		} else {
			int min = num.get(i);
			int index = -1;
			int eleToSwap = num.get(i - 1);
			for (int j = i; j < num.size(); j++) {
				if (num.get(j) > eleToSwap && num.get(j) < min) {
					min = num.get(j);
					index = j;
				}
			}
			num.set(i - 1, min);
			num.set(index, eleToSwap);

		}

		int[] arr = { 2, 1, 8, 7, 6, 5 };
		findNextGreatorNumber(arr);

	}

	public static void findNextGreatorNumber(int[] arr) {
		//{2,1, 8, 7, 6, 5} 
		int i = arr.length -1;	// i = 5
		while(arr[i-1] > arr[i])
			i--;					// i = 2

		int min = i, eleToSwap = arr[i-1];
		for(int j = arr.length -1; j>0; j--) {
			if(arr[j] > eleToSwap && arr[j] < arr[min]) {
				min = j;
			}
		}
		swap(arr, min, i-1);
		Arrays.sort(arr, i, arr.length);
		for(int k =0 ; k< arr.length; k++) {
			System.out.print(arr[k]);
		}
		
	}

	public static void swap(int[] arr1, int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp;
	}
}
