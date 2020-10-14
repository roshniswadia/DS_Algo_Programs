package com;

public class NextPermutationLexicographicSTR {

	
	public static void main(String[] args) {
		//abedc
		// next => acbde
		
		String nextPermutation = findNextString("abedc");
		System.out.println("Next Per : " + nextPermutation);
	}
	
	public static String findNextString(String str) {
		char arr[] = str.toCharArray();
		int i = arr.length - 1;
		while(i >0 && arr[i] <= arr[i-1]) { // i=4 c, 3 d, 2 e
			i--;
		}
		
		if(i <= 0) {
			return null;
		}
		
		int j = arr.length - 1;
		while(arr[i -1] > arr[j]) { // 4, c
			j--;
		}
		
		char temp = arr[j];
		arr[j] = arr[i - 1];
		arr[i -1] = temp;
		
		String outputStr = new String(arr);
		StringBuilder s2 = new StringBuilder(outputStr.substring(i)).reverse();
		String s1 = outputStr.substring(0, i) + s2.toString();
		return s1;
	}
	
	
}
