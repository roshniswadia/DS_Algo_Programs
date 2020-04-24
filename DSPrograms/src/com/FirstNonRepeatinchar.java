package com;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatinchar {

	static final int NO_OF_CHARS = 256;
	static char count[] = new char[NO_OF_CHARS];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "zzazzzbbbccccddehhhhiii";
		findFirstNonRepeating(str);
		firstNonRepeatedCharacter(str);
		findNonRepeatChar(str);

	}

	public static void findFirstNonRepeating(String str) {
		char[] inputStr = str.toCharArray();
		Map<Character, Integer> charSet = new LinkedHashMap<>();

		for (int i = 0; i < inputStr.length; i++) {
			if (charSet.containsKey(inputStr[i])) {
				charSet.put(inputStr[i], charSet.get(inputStr[i]) + 1);
			} else {
				charSet.put(inputStr[i], 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : charSet.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("Fiirst Non Repeating char is : " + entry.getKey());
				break;
			}
		}
	}

	public static void firstNonRepeatedCharacter(String word) {
		HashMap<Character, Integer> scoreboard = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}
		// since HashMap doesn't maintain order, going through string again
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.get(c) == 1) {
				System.out.println("Fiirst Non Repeating char is : " + c);
				break;
			}
		}
	}

	public static void findNonRepeatChar(String str) {

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				System.out.println("first non repeating char is : " + str.charAt(i));
				break;
			}
		}

	}

}
