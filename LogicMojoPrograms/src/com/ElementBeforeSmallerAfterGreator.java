package com;

/*We have an array, we have to find an element before which all elements are less than it, 
and after which all are greater than it. Finally, return the index of the element, 
if there is no such element, 
then return -1: Time complexity O(n) and Space Complexity O(n)*/
public class ElementBeforeSmallerAfterGreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };

		int leftMax[] = new int[arr.length];
		int rightMin[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], i);
		}

		for (int i = arr.length - 2; i > 0; i++) {
			rightMin[i] = Math.min(rightMin[i + 1], rightMin[i+1]);
		}

	}

}
