package com;

/*We have an array, we have to find an element before which all elements are less than it, 
and after which all are greater than it. Finally, return the index of the element, 
if there is no such element, 
then return -1: Time complexity O(n) and Space Complexity O(n)*/
public class ElementBeforeSmallerAfterGreator {

	public static void main(String[] args) {
		int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9};

		int leftMax[] = new int[arr.length];
		int rightMin[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);// {0, 5, 5, 5, 6, 8,10, 10, 10}
		}

		int right = Integer.MAX_VALUE;
		for (int i = arr.length - 2; i > 0; i--) {
			if(arr[i] > leftMax[i-1] && arr[i] < right) {
				System.out.println(arr[i]);
				break;
			}
			right = Math.min(right, arr[i+1]);
		}

	}

}
