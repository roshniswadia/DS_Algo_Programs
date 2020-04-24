package com;

import java.util.Arrays;

public class TwoStringAnagram {
	
	static int NUMBER_OF_CHARS = 256;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "testrihnjp"; 
	    String str2 = "abchdgestt"; 
	    if (areAnagram(str1, str2)) 
	        System.out.println("The two strings are anagram of each other"); 
	    else
	        System.out.println("The two strings are not anagram of each other"); 
	}
	
	public static boolean areAnagram(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		
		int[] charCount = new int[256];
		Arrays.fill(charCount, 0);
		
		for(int i =0; i< str1.length(); i++) {
			charCount[str1.charAt(i)]++;
			charCount[str2.charAt(i)]--;
		}
		
		for(int i=0; i<charCount.length; i++) {
			if(charCount[i] == 1 || charCount[i] == -1)
				return false;
		}
		
		return true;
	}

}
