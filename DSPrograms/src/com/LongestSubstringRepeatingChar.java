package com;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "abcabcbbtefhjkop";
		
		int pointer1 = 0;
		int pointer2 = 0;
		int max_length = 0;
		
		Set<Character> set = new HashSet<>();
		
		while(pointer1 < str1.length()) {
			if(set.contains(str1.charAt(pointer1))) {
				set.remove(str1.charAt(pointer2));
				pointer2++;
			}else {
				set.add(str1.charAt(pointer1));
				max_length = Math.max(max_length, pointer1 - pointer2 + 1);
				pointer1++;
			}
		}

		System.out.println("Max Lenght String without repeating char : " + max_length);
	}

}
