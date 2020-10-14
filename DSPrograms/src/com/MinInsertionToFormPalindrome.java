package com;

public class MinInsertionToFormPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMinInsertions("abcd", 0, 3));
	}
	
	public static int findMinInsertions(String str, int start, int end) {
		
		if(start > end)
			return Integer.MAX_VALUE;
		
		if(start == end -1)
			return str.charAt(start) == str.charAt(end) ? 0 : 1;
		
		if(start == end)
			return 0;
		
		if(str.charAt(start) == str.charAt(end))
			return findMinInsertions(str, start + 1, end - 1);
		else
			return Math.min(findMinInsertions(str, start + 1, end),  findMinInsertions(str, start, end - 1)) + 1;
		
	}

}
