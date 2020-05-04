package com;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println("Is Happy Num ?" + isHappyNum(19));
	}

	public static boolean isHappyNum(int number) {
		int sum = 0;
		boolean isHappy = true;
		Set<Integer> sumMap = new HashSet<>();
		
		while(isHappy) {
			
			while(number !=0) {
				int a = number%10;
				sum = sum + a*a;
				number = number/10;
			}
			if(sumMap.contains(sum)) {
				isHappy = false;
			}else{
				sumMap.add(sum);
			}
			number = sum;
			if(sum == 1){
				isHappy = true;
                break;
            }
			sum=0;
			
		}
		
		return isHappy;
				
	}
}
