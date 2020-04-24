package com;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumberFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> arr = new Vector<>();
		arr.add("1");
		arr.add("27");
		arr.add("2");
		arr.add("4");
		arr.add("6");
		arr.add("7");
		arr.add("23434");

		Comparator<String> intComp = (String str1, String str2) -> {
			String A = str1 + str2;
			String B = str2 + str1;
			return A.compareTo(B) > 0 ? -1:1; 
			
		};

		Collections.sort(arr, intComp);
		StringBuilder str = new StringBuilder();
		
		Iterator<String> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
	}

}
