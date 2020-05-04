package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddingOneToNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,9,9};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		incrementArray(list);
		
		list.stream().forEach(System.out::println);
		
	}
	
	public static void incrementArray(List<Integer> list) {
		int size = list.size();
		
		list.set(size - 1, list.get(size - 1) + 1);
		int carry = list.get(size-1)/10;
		list.set(size - 1, list.get(size - 1)%10);
		
		for(int i=size - 2; i >=0 ;i--) {
			if(carry == 1) {
				list.set(i, list.get(i) + 1);
				carry = list.get(i)/10;
				list.set(i, list.get(i)%10);
			}
		}
		
		if(carry == 1) {
			list.add(0, 1);
		}
			
	}

}
