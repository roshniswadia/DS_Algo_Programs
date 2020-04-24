package com.customTP;

public class CustomThreadpool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPool pool = new ThreadPool(10);
		
		for(int i=0; i<= 10; i++) {
			pool.execute(new Task(i));
		}

		for(int i=12; i<= 20; i++) {
			pool.execute(new Task(i));
		}

	}

}
