package com.customTP;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	
	private final int nThreads;
	private final LinkedBlockingQueue queue;
	private final PoolWorker[] workerThreads;
	
	public ThreadPool(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedBlockingQueue<>();
		workerThreads = new PoolWorker[nThreads];
		for(int i=0; i<nThreads; i++) {
			workerThreads[i] = new PoolWorker();
			workerThreads[i].start();
		}
	}

	public void execute(Runnable task) {
		 synchronized (queue) {
	            queue.add(task);
	            queue.notify();
	        }
	}
	
	private class PoolWorker extends Thread{
		Runnable task;
		
		public void run() {
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					task = (Runnable) queue.poll();
				}
				task.run();
			}
		}
	}
}
