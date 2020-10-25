package com;

public class Demo {

	public static void main(String[] args) {
		System.out.println(Weekday.FRIDAY);
		
		int  wd = Weekday.FRIDAY.ordinal();
		System.out.println(wd);
		
		System.out.println(Weekday.valueOf("FRIDAY"));
		
		
		Weekday arr[] = Weekday.values();
		for(Weekday weekday : arr) {
			System.out.println(weekday.ordinal());
		}
	}
}
