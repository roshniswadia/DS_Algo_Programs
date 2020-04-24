package com;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class J12To24Hour {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */
		String timein24Format;
		String inputArr[] = s.split(":");
		String meridiem = inputArr[2].substring(2);

		int newTime = 0;
		if (meridiem.equalsIgnoreCase("PM")) {
			int i = Integer.parseInt(inputArr[0]);
			if (i == 12) {
				timein24Format = s.substring(0, 8);
			} else {
				newTime = 12 + i;
				timein24Format = String.valueOf(newTime) + s.substring(2, 8);
			}
		} else {
			int i = Integer.parseInt(inputArr[0]);
			if (i == 12) {
				timein24Format = "00" + s.substring(2, 8);
			} else {
				timein24Format = s.substring(0, 8);
			}
		}
		return timein24Format;

	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = "12:05:45AM";

		String result = timeConversion(s);
		System.out.println(result);
	}
}
