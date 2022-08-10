package com;

import java.util.Arrays;

/*String is given as input that contains only lowercase letters, 
remove duplicate letters so that every letter appears once In O(n) 
Time Complexity and O(1) Space Complexity*/
public class RemoveDeplicateFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "aabhglyureb";
		StringBuilder strOutput = new StringBuilder(str);
		int[] arr = new int[26];
		int index = 0;
		int deleteCount =0;
		Arrays.fill(arr, -1);
		for (int i = 0; i < str.length(); i++) {
			int value = (int)str.charAt(i);
			index = value - 97;
			if(arr[index] == 1) {
				strOutput.deleteCharAt(i - deleteCount);
				deleteCount++;
			}else {
				arr[index] = 1;
			}
		}

		removeDuplicateChars(str);
		System.out.println("String without Duplicates : " + strOutput.toString());
	}

	public static void removeDuplicateChars(String str) {
		char[] strArr = str.toCharArray();
		int[] ascii = new int[256];
		for(int i=0; i<strArr.length; i++) {
			if(ascii[strArr[i]] == 0) {
				ascii[strArr[i]] = -1;
			}else {
				strArr[i] = '\0';
			}
		}
		
		str = String.valueOf(strArr).replace("\0", "");
		System.out.println(str);
	}
}
