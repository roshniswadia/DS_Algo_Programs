package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class LargestNumberFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> arr = new Vector<>();
		/*
		 * arr.add("1"); arr.add("27"); arr.add("2"); arr.add("4"); arr.add("6");
		 * arr.add("7"); arr.add("23434");
		 */

		arr.add("8");
		arr.add("89");

		Comparator<String> intComp = (String str1, String str2) -> {
			String A = str1 + str2;
			String B = str2 + str1;
			return A.compareTo(B) > 0 ? -1 : 1;

		};

		Collections.sort(arr, intComp);
		StringBuilder str = new StringBuilder();

		Iterator<String> itr = arr.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		List<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(0);
		A.add(0);
		System.out.println(testMethod(A));

	}

	public static String testMethod(List<Integer> A) {

		String newNumber = null;
		List<String> newList = new ArrayList<>();
		A.forEach(a -> newList.add(String.valueOf(a)));
		Collections.sort(newList, new Comparator() {

			@Override
			public int compare(Object a1, Object b1) {
				String a = (String) a1;
				String b = (String) b1;
				String firstNum = a + b;
				String secondNum = b + a;

				Integer first = Integer.parseInt(firstNum);
				Integer second = Integer.parseInt(secondNum);
				if (first > second)
					return -1;
				else if (second > first)
					return 1;
				else
					return 0;

			}
		});

		String output = "";
		int countOfAllZeroes = 0;
		for (int i = 0; i < A.size(); i++) {
			if(newList.get(i).equals("0"))
				countOfAllZeroes ++;
			output = output + newList.get(i);
		}
		if(countOfAllZeroes == A.size())
			return "0";
		return output;
	}
	
	// String result = A.stream()
		//        .map(i -> i.toString())
		  //      .sorted(Solution::reversedComparing)
		    //    .collect(java.util.stream.Collectors.joining(""));
		      //  return result.substring(nonZeroStartIndexIn(result), result.length());
		    //}
		   // private static int nonZeroStartIndexIn(String str) {
		    //    int i = 0;
		    //    for(;i < str.length() - 1 && str.charAt(i) == '0'; i++) {}
		    //    return i;
		   // }

		    //private static int reversedComparing(String s1, String s2) {
		    //    return s2.concat(s1).compareTo(s1.concat(s2));
		    //}

}
