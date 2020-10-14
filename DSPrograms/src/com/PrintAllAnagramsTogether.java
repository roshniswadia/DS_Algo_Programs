package com;

import java.util.Arrays;
import java.util.Comparator;

public class PrintAllAnagramsTogether {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String wordArr[] = { "cat", "dog", "tac", "god", "act" }; 
        int size = wordArr.length; 
        printAnagramsTogether(wordArr); 
	}
	
	static class WordComparator implements Comparator<Word>{

		@Override
		public int compare(Word o1, Word o2) {
			return o1.str.compareTo(o2.str);
		}
		
	}
	
	public static void printAnagramsTogether(String[] wordArr) {
		DupsArray duplicateArray = new DupsArray(wordArr, wordArr.length);
		
		for(int i=0; i < wordArr.length; i++) {
			char[] arr = duplicateArray.words[i].str.toCharArray();
			Arrays.sort(arr);
			duplicateArray.words[i].str = new String(arr);
		}
		
		Arrays.sort(duplicateArray.words, new WordComparator());
		
		for(int i=0; i<wordArr.length ; i++) {
			System.out.println(wordArr[duplicateArray.words[i].index]);
		}
	}
	
	static class Word{
		String str;
		int index;
		
		public Word(String str, int index) {
			this.str = str;
			this.index = index;
		}
	}
	
	static class DupsArray{
		Word[] words;
		int size;
		
		public DupsArray(String[] wordArr, int size) {
			words = new Word[size];
			
			for(int i=0; i<size; i++) {
				words[i] = new Word(wordArr[i], i);
			}
		}
	}

}
