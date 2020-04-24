package com;

public class LongestCommonSubRecursion {

	static String s1 = "AGGTABS";
	static String s2 = "GXTXAYBS";

	static char[] X = s1.toCharArray();
	static char[] Y = s2.toCharArray();

	public static void main(String[] args) {

		int commonSubSeqLenght = findCommonSub(0, 0);
		System.out.println("Longest Common Sub : " + commonSubSeqLenght);
	}

	public static int findCommonSub(int index1, int index2) {
		if (index1 > X.length - 1 || index2 > Y.length - 1) {
			return 0;
		} else if (X[index1] == Y[index2]) {
			return 1 + findCommonSub(index1 + 1, index2 + 1);
		} else {
			return Math.max(findCommonSub(index1, index2 + 1), findCommonSub(index1 + 1, index2));
		}
	}

}
