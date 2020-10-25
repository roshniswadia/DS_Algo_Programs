package com.trappingWater;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.
            |__|
 __         |__| 
|__|   __   |__|
|__|  |__|  |__|
|__|__|__|__|__|

*/

public class TrappingRainwater {

	public static void main(String[] args) {
		
		int[] inputArr = {3, 0, 2, 0, 4};
		
		int Lptr = 0;
		int Rptr = 4;
		int level = 0;
		int result =0;
		while(Lptr < Rptr) {
			//You will get the lower value from left and right wall
			int lower = inputArr[inputArr[Lptr] < inputArr[Rptr] ? Lptr++ : Rptr--]; //3, 0
			
			level = Math.max(level, lower);
			result += level - lower;
		}
		
	}
}
