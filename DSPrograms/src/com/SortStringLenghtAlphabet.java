package com;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringLenghtAlphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = {"abc", "efg", "ab", "hgyns", "jshhass", "ahjns", "ahans"};
		
		Comparator<String> strComp = (String str1, String str2) ->{
			if(str1.length() < str2.length())
				return -1;
			else if(str1.length() > str2.length()) {
				return 1;
			}else {
				return str1.compareTo(str2);
			}
		};
		
		// TODO using lambda
		
		Arrays.sort(arr, strComp);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
