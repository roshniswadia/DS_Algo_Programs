package com;

public class MaxPalidromeSubStringInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "racecar";
		String str2 = "forgeeksskeegfor";
		int maxLengthPalin = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for(int i=0 ; i< str1.length(); i++) {
			int len1 = expandFromMiddle(str1, i, i);
			int len2 = expandFromMiddle(str1, i, i + 1);
			int len = Math.max(len1, len2); // forgeeksskeegfor i=7 len = 4 start = 6
			if(len > end - start) {
				start = i - ((len -1)/2);
				end = i + (len/2);
			}
		}

		System.out.println("Longest Palidrome is : " + str1.substring(start, end + 1));
	}
	
	static int expandFromMiddle(String str, int left, int right) {
		if(str == null || left > right)
			return 0;
		
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right ++;
		}
		
		return right - left - 1;
	}

}
