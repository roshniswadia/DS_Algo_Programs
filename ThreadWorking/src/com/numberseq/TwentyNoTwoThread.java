package com.numberseq;

public class TwentyNoTwoThread extends Thread {
	
	int threadNo;
	final static Object obj = new Object();
	static int counter = 1;
	
	public TwentyNoTwoThread(int threadNo) {
		// TODO Auto-generated constructor stub
		this.threadNo = threadNo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwentyNoTwoThread t1 = new TwentyNoTwoThread(1);
		TwentyNoTwoThread t2 = new TwentyNoTwoThread(2);
		
		t1.start();
		t2.start();

	}
	
	@Override
	public void run() {
		synchronized (obj) {
			while(counter <=20) {
				if((counter <=10 && threadNo ==1) || (counter>10 && threadNo == 2)) {
					System.out.println("Counter : " + counter + " Thread-" + threadNo);
					counter++;
					obj.notify();
				}else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}

}
