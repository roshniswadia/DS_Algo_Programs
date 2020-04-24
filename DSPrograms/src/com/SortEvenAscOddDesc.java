package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenAscOddDesc {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 5, 4, 7, 10};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Comparator<Integer> comp = (Integer a, Integer b) -> {
			if(a%2 ==0 && b%2==0)
				return a >= b ? 1 :-1;
				
			if(a % 2 !=0 && b%2 != 0)
				return b >= a ? 1 : -1;
				
			if(a%2 == 0)
				return 1;
			
			return -1;
				
		};
		
		Collections.sort(list, comp);
		
		for(int lst : list) {
			System.out.println(lst);
		}
	}

}
