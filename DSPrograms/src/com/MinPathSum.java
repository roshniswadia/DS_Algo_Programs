package com;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 3, 3 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println("Minimum Path Sum : " + findMinPath(arr, arr.length -1, arr[0].length -1));
		
		System.out.println("Minimum Path Sum : " + findMinPathDp(arr));

	}

	public static int findMinPath(int[][] arr, int rowEnd, int columnEnd) {
		
		if(rowEnd < 0 || columnEnd < 0)
			return Integer.MAX_VALUE;
		
		if(rowEnd ==0 && columnEnd ==0)
			return arr[0][0];

		return arr[rowEnd][columnEnd]
				+ Math.min(findMinPath(arr, rowEnd - 1, columnEnd), findMinPath(arr, rowEnd, columnEnd - 1));
	}
	
	public static int findMinPathDp(int[][] arr) {
		if(arr.length == 0 || arr == null)
			return 0;
		
		int[][] dp = new int[arr.length][arr[0].length];
		
		dp[0][0] = arr[0][0];
		
		for(int i= 1; i<= arr.length -1; i++)
			dp[i][0] = arr[i][0] + dp[i-1][0];
		
		for(int i= 1; i<= arr.length -1; i++)
			dp[0][i] = arr[0][i] + dp[0][i-1];
		
		for(int i =1; i<=arr.length -1; i++) {
			for(int j=1; j <= arr[0].length -1; j++) {
					dp[i][j] = arr[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[arr.length -1][arr[0].length -1];
	}

}
