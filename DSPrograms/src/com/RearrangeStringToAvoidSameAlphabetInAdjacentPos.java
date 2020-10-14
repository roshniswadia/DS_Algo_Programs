package com;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringToAvoidSameAlphabetInAdjacentPos {
	
	static class KeyComparator implements Comparator<Key>{

		@Override
		public int compare(Key key1, Key key2) {
			if(key1.freq > key2.freq)
				return 1;
			else if(key1.freq < key2.freq)
				return -1;
			else 
				return 0;
		}
		
	}
	
	static class Key{
		char ch;
		int freq;
		
		public Key(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	public static void main(String[] args) {
		
		final int numOfChars = 26;
		String str = "aaaabc";// a,b,c => abaca
		rearrangeString(str);
	}
	
	static void rearrangeString(String str) {
		 Map<Character, Integer> charCountMap = new HashMap<>();
		 PriorityQueue<Key> queue = new PriorityQueue<>(new RearrangeStringToAvoidSameAlphabetInAdjacentPos.KeyComparator());
		 
		 for(int i=0; i < str.length(); i++) {
			 if(charCountMap.containsKey(str.charAt(i))) {
				 charCountMap.put(str.charAt(i), charCountMap.get(str.charAt(i)) + 1);
			 }else {
				 charCountMap.put(str.charAt(i), 1);
			 }
		 }
		 
		 charCountMap.forEach((k,v) -> {
			 queue.add(new Key(k, v));
		 });
		 
		 Key prev = new Key('#', -1); 
		 String newstr = "";
		 
		 while(!queue.isEmpty()) {
			 Key k = queue.poll();
			 
			 if(prev.freq > 0)
				 queue.add(prev);
			 
			 newstr = newstr + k.ch;
			 
			 k.freq--;
			 prev = k;
		 }
		 
		 if(newstr.length() == str.length()) {
			 System.out.println("New String : " + newstr);
		 }else {
			 System.out.println("String cannt be rearranged");
		 }
	}

}
