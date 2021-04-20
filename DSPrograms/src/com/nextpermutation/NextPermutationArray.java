package com.nextpermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutationArray {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();//4,5,6,3.2.1
		//list.add(4);
		//list.add(5);
		//list.add(6);
		//list.add(3);
		//list.add(2);
		//list.add(1);
		
		list.add(769);
		list.add(533);
		
		List<Integer> output = nextPermutation(list);
		System.out.println(output);
		
	}
	
	 public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
		 
		 int i = A.size()-1;
	        while(i > 0 && A.get(i) <= A.get(i-1)) { //i=4 (index 2)
	        	i--;
	        }
	        
	        if(i <= 0) {
	        	Collections.sort(A);
	        	return A;
	        }
	        
	        int j= A.size() -1;
	        while(A.get(i-1) > A.get(j)) {
	        	j--;
	        }
	        
	        swap(A, i-1, j);
	        reverse(A, i, A.size()-1);
	        return A;
	    }
	 
	 public static void swap(List<Integer> A, int a, int b) {
		 int temp = A.get(a);
	        A.set(a, A.get(b));
	        A.set(b, temp);
	 }
	 
	 public static void reverse(List<Integer> A, int start, int end) {
		 while(start < end) {
			 swap(A, start, end);
			 start++;
			 end--;
		 }
	 }
}
