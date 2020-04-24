package com;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int arr1[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int lis[] = new int[arr1.length];

		int prevSebSeqIndex[] = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < arr1.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr1[i] > arr1[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
					prevSebSeqIndex[i] = j;
				}
			}
		}

		int max = 0;
		int maxIndexLoc = 0;
		for (int i = 0; i < lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
				maxIndexLoc = i;
			}
		}

		System.out.println("Increasing Sub sequence");
		int index = maxIndexLoc;
		while (index > 0) {
			System.out.println(arr1[index]);
			index = prevSebSeqIndex[index];
		}

		System.out.println("Max length of increasing sub sequence : " + max);
	}
}
