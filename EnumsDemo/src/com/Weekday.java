package com;

public enum Weekday {
	
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	
	public int value;
	
	Weekday(int value){
		this.value = value;
	}
	
}
