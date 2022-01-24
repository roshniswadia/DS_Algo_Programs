package com;

import java.util.Arrays;

/*Given the arrival and departure times of all trains that 
reach a railway station, the task is to find the minimum number 
of platforms required 
for the railway station so that no train waits. */
public class MinimumPlatforms {

	public static void main(String[] args) {

		long arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		long dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		Arrays.sort(dep);
		int i = 0, j = 0;
		int numberOfPlatforms = 0;
		int maxPlatforms = 0;
		int n = arr.length;
		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				numberOfPlatforms++;
				if (maxPlatforms < numberOfPlatforms)
					maxPlatforms = numberOfPlatforms;
				i++;
			} else {
				numberOfPlatforms--;
				j++;
			}
		}

		System.out.println("Max number of platforms required : " + maxPlatforms);

	}

}
