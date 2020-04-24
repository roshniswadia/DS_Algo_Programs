package com.numberseq;

public class PrintNumberSeq {

	volatile static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(() -> {
			while (counter < 10) {
				System.out.println(counter);
				counter++;
			}
		});

		Thread t2 = new Thread(() -> {
			while (counter < 10) {
				System.out.println(counter);
				counter++;
			}

		});

		Thread t3 = new Thread(() -> {
			while (counter < 10) {
				System.out.println(counter);
				counter++;
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

}
