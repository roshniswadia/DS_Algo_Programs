package com;

/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
*/
public class DetectCapitalLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "WWWWaaaaa";
		System.out.println("String is valid : " + detectCapitalUse(str));
	}

	public static boolean detectCapitalUse(String word) {
		if(word.isEmpty())
			return false;
		
		
		char[] letters  = word.toCharArray();
		boolean isValid = true;
		for(int i = 1 ; i< letters.length; i++) {
			if(isCharUppercase(letters[i]) && i != 0 && 
					!isCharUppercase(letters[i-1])) {
				isValid = false;
			}else if(!isCharUppercase(letters[i])  && isCharUppercase(letters[i-1])) {
				isValid  = false;
			}
		}
		return isValid;
	}
	
	public static boolean isCharUppercase(char ch) {
		if(ch >= 'A' && ch <= 'Z')
			return true;
		else 
			return false;
	}
	
	public static boolean betterSolution(String word) {
		char[] letters = word.toCharArray();
		int count = 0;
		for(int i=0 ; i< letters.length; i++) {
			if(isCharUppercase(letters[i]))
				count++;
		}
		
		return count == letters.length -1 || count ==0 || count == 1 && isCharUppercase(letters[0]);
	}

}
