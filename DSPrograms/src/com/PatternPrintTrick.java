package com;

public class PatternPrintTrick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		String str = "#";
		for (int i = 0; i < n; i++) {
			System.out.printf("%" + (n + 1) + "s", str + "\n");
			str = str + "#";
		}
	}

}
