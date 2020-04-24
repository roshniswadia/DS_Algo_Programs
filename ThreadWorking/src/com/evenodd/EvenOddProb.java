package com.evenodd;

public class EvenOddProb extends Thread {

	boolean odd;
	int counter = 1;

	public void printOdd() {
		synchronized (this) {
			while (counter <= 100) {
				if (odd) {
					System.out.println("Counter : " + counter + " Thread-" + Thread.currentThread().getName());
					counter++;
					odd = false;
					this.notify();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void printEven() {
		synchronized (this) {
			while (counter <= 100) {
				if (!odd) {
					System.out.println("Counter : " + counter + " Thread-" + Thread.currentThread().getName());
					counter++;
					odd = true;
					this.notify();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenOddProb evenOddTh = new EvenOddProb();
		evenOddTh.odd = false;

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				evenOddTh.printOdd();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				evenOddTh.printEven();
			}
		});	
		
		t1.start();
		t2.start();
	}

}
