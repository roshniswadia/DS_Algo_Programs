package com;

public class MinCoinsRequired {

	public static void main(String[] args) {
		int denominationArray[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

		int totalSum = 1534;

		int minCoins = findMinCoin(totalSum, denominationArray);
		System.out.println(minCoins);
	}

	static int findMinCoin(int sumReq, int arr1[]) {
		int mincoins = 0;
		for (int i = arr1.length - 1; i >= 0; i--) {
			int noteCount = sumReq / arr1[i];
			if (noteCount != 0) {
				mincoins = mincoins + noteCount;
				sumReq = sumReq - (arr1[i] * noteCount);
			}
		}
		return mincoins;
	}
}
