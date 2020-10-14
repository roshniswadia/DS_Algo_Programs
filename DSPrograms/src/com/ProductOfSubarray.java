package com;

public class ProductOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 2, 4 };
		int[] arr2 = { 10, 3, 7 };
		findAllSubArrays(arr2);
		productOfarray(arr2);
	}

	public static void findAllSubArrays(int[] arr) {
		long product = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				product = product * getProduct(arr, i, j);
			}
		}

		System.out.println("Product : " + product);
	}

	public static long getProduct(int[] arr, int start, int end) {
		long product = 1;
		for (int i = start; i <= end; i++) {
			product = product * arr[i];
		}
		return product;
	}

	private static void productOfarray(int[] a) {
		double pow;
		if (a.length % 2 == 0) {
			int minusVal = a.length - 1 - 2;
			if (minusVal < 0) 
				minusVal = 0;
			pow = Math.pow(2, a.length - 1) - minusVal;
		} else {
			pow = Math.pow(2, a.length - 1);
		}
		System.out.println("pow " + pow);
		double product = 1;
		for (int i = 0; i < a.length; i++) {
			product *= Math.pow(a[i], pow);
		}
		System.out.println("Your product is :" + (int) product);
	}
}
