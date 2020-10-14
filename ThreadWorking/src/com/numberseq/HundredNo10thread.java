	package com.numberseq;

public class HundredNo10thread extends Thread {

//define the Total No.Of Threads needed
	public static final int TOTAL_THREADS = 10;

	public final static  Object obj = new Object();

	int threadNo;
	static int counter = 1;

	public HundredNo10thread(int threadNo) {
		this.threadNo = threadNo;
	}

	@Override
	public void run() {

		// in a synchronized block to acquire lock
		synchronized (obj) {

			while (counter <= 100) {
				if ((counter % TOTAL_THREADS == threadNo)
						|| ((counter % TOTAL_THREADS == 0) && (TOTAL_THREADS == threadNo))) {
					System.out.println(this.threadNo + " printing" + " " + counter++);

					obj.notifyAll();
				} else {

					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String args[]) {

		for (int i = 1; i <= TOTAL_THREADS; i++) {
			HundredNo10thread th = new HundredNo10thread(i);
			th.start();
		}
	}
}