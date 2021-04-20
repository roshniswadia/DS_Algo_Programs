package com;

/* Given an array of Integers. find the last and first index of a given number in the array
 * 
 */
public class FirstLastPosLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = { 5, 7, 7, 8, 10 };

		 int[] arr = {3,3,3};

		int[] targetRange = searchRange(arr, 3);

		System.out.println("MinIdex , MaxIdex" + targetRange[0] + "," + targetRange[1]);

	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		int start = 0; //0
		int end = nums.length - 1; //4
		while (start <= end) {
			//int mid = start + ((end - start) / 2); // 2, 3
			int mid = (start + end)/2;
			if (nums[mid] == target) {
				result[0] = findStart(nums, start, mid, target);
				result[1] = findEnd(nums, mid, end, target);
				return result;
			} else if (nums[mid] < target) {
				start = mid + 1; //3
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	public static int findStart(int[] nums, int start, int end, int target) {
		int result = end;
		while (start <= end) {
			int mid = (start + end)/2;
			if (nums[mid] == target) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public static int findEnd(int[] nums, int start, int end, int target) {
		int result = start;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (nums[mid] == target) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}
}
