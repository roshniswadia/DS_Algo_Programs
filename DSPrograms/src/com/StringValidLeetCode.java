package com;

import java.util.Stack;

public class StringValidLeetCode {
	
	static Stack<Integer> openBracStack = new Stack<>();
	static Stack<Integer> starStack = new Stack<>();

	public static void main(String[] args) {

		String[] s1 = {"(*))", ")*()", "**())", "("};
		
		for(int i = 0; i<s1.length; i++) {
			boolean value = ValidateString(s1[i]);
			System.out.println("String " + s1[i] + " is valid => " + value );
			openBracStack.clear();
			starStack.clear();
		}
	}
	
	public static boolean ValidateString(String s) {
		char[] ch1 = s.toCharArray();
		
		for(int j = 0 ; j<ch1.length ; j++) {
			if(ch1[j] == '(') {
				openBracStack.push(j);
			}else if(ch1[j] == ')') {
				if(!openBracStack.isEmpty() && openBracStack.peek() < j) {
						openBracStack.pop();
				}else if(!starStack.isEmpty() && starStack.peek() < j) {
						starStack.pop();
				}else {
					return false;
				}
			}else {
				starStack.push(j);
			}
		}
		
		while(!openBracStack.isEmpty()) {
			int indexofOpenBrac = openBracStack.peek();
			if(!starStack.isEmpty() && indexofOpenBrac < starStack.peek()) {
				starStack.pop();
				openBracStack.pop();
			}else {
				return false;
			}
		}
		
		return true;
	}

}
