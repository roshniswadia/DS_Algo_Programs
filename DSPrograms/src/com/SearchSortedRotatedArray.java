package com;

public class SearchSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4,5,6,7,0,1,2,3};
		int searchElement = 6;
		
		int searchIndex2 = searchElement(arr, searchElement);
		
		System.out.println("Search Index : " + searchIndex2);
	}
	
	
	static int searchElement(int[] arr, int target) {
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(target == arr[mid]) {
				return mid;
			}else if(arr[mid] > arr[start]) {
				if(target >= arr[start] && target <= arr[mid])
					end = mid -1;
				else 
					start = mid + 1;
			}else {
				if(target >= arr[mid] && target <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		
		return -1;
	}
}
