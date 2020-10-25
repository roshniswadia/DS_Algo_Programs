package com;
/* Given an array of Integers. find the last and first index of a given number in the array
 * 
 */
public class FirstLastPosLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,7,8,10};
		
		//int[] arr = {3,3,3};
		
		int[] targetRange = searchRange(arr, 8);
		
		System.out.println( "MinIdex , MaxIdex" + targetRange[0] + "," + targetRange[1]);

	}
	
	public static int findFirstPos(int[] arr, int start, int end , int target) {
		if(start > end)
			return Integer.MAX_VALUE;
		
		int mid = (start + end) /2;
		int minIndex = Integer.MAX_VALUE;
		if((mid == 0 || arr[mid-1] < target ) && target == arr[mid]) {
			return Math.min(minIndex, mid);
		}else if(mid !=0 && (arr[mid -1] >= target)) {
			return Math.min(minIndex, findFirstPos(arr, start, mid -1,  target));
		}else if((mid != arr.length -1) && (arr[mid + 1] <= target)) {
			return Math.min(minIndex, findFirstPos(arr, mid + 1, end,  target));
		}
		return -1;
	}
	
	public static int findLastPos(int[] arr, int start, int end , int target) {
		if(start > end)
			return Integer.MIN_VALUE;
		
		int mid = (start + end) /2;
		int maxIndex = Integer.MIN_VALUE;
		if((mid == (arr.length - 1) || arr[mid+1] > target ) && target == arr[mid]) {
			return Math.max(maxIndex, mid);
		}else if(mid !=0 && (arr[mid -1] >= target)) {
			return Math.max(maxIndex, findLastPos(arr, start, mid -1,  target));
		}else if((mid != arr.length -1) && (arr[mid + 1] <= target)) {
			return Math.max(maxIndex, findLastPos(arr, mid + 1, end,  target));
		}
		return -1;
	}
	
	private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

}
