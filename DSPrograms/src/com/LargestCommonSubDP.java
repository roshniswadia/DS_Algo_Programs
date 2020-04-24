package com;

public class LargestCommonSubDP {
	static String s1 = "AGGTABS";
	static String s2 = "GXTXAYBS";

	static char[] X = s1.toCharArray();
	static char[] Y = s2.toCharArray();

	static int[][] lcs = new int[X.length + 1][Y.length + 1];

	public static void main(String[] args) {

		for (int i = 0; i <= X.length; i++) {
			for (int j = 0; j <= Y.length; j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
			}
		}

		System.out.println("Longest Common Sub length : " + lcs[X.length][Y.length]);

	}
}
