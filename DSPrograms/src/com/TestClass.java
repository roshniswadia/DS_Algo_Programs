package com;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "This is tutorials point";
		int startLength = 4;
		int endLength = 8;
		char replaceWithCh = 't';

		int replaceCount = (endLength - startLength) + 1;

		StringBuilder r = new StringBuilder();
		for (int i = 0; i < replaceCount; i++) {
			r.append("a");
		}

		StringBuilder input1 = new StringBuilder();
		input1.append(str);
		System.out.println(input1.substring(0, startLength) + r + input1.substring(endLength + 1));

		System.out.println("");
	}

}
