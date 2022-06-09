package com;

public class StaticNestedClassDemo {

	
	private static int outer_x = 10;
	private int outer_y = 6;
	
	int outer_z = 9;
	
	static class InnerClass{
		int inner_y;
		
		static int inner_x = 10;
		StaticNestedClassDemo obj = new StaticNestedClassDemo();
		
		void display() {
			System.out.println("inner y : " + inner_y);
			System.out.println("inner x : " + inner_x);
			System.out.println("Outer x : " + outer_x);
			System.out.println(obj.outer_y);
		}
		
		
		
	}
}
