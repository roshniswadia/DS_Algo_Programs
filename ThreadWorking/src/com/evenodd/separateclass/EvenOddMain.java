package com.evenodd.separateclass;

public class EvenOddMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Lock lock = new Lock(1);
			Integer id = new Integer(1);

			Even obj1 = new Even(lock);
			obj1.start();
			Odd obj2 = new Odd(lock);
			obj2.start();

	}

}
