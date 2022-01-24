package com;/*
Given two rectangles, find if the given two rectangles overlap or not.
Note that a rectangle can be represented by two coordinates, top left and bottom right. So mainly we are given following four coordinates. 
l1: Top Left coordinate of first rectangle. 
r1: Bottom Right coordinate of first rectangle. 
l2: Top Left coordinate of second rectangle. 
r2: Bottom Right coordinate of second rectangle.*/

public class OverlappingRectanlges {

	static class Point {
		int x, y;
	}

	public static void main(String[] args) {
		Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
		l1.x = 0;
		l1.y = 10;
		r1.x = 10;
		r1.y = 0;
		l2.x = 5;
		l2.y = 5;
		r2.x = 15;
		r2.y = 0;
		boolean isOverlapping = isOverlapping(l1, l2, r1, r2);
		if(isOverlapping)
			System.out.println("Rectangles are overlapping");
		else
			System.out.println("Rectangles are not overlapping");

	}

	private static boolean isOverlapping(Point l1, Point l2, Point r1, Point r2) {
		if (l1.x >= r2.x || l2.x >= r1.x) {
			return false;
		}

		if (r1.y >= r2.x || l2.x >= r1.x) {
			return false;
		}

		if (l1.y == r1.y || l1.x == r1.x || l2.y == r2.y || l2.x == r2.x) {
			return false;
		}
		return true;
	}

}
