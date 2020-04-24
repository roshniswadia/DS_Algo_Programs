package com.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ServiceOne implements Runnable {
	
	private final CyclicBarrier cyclicBarrier;
	 
    public ServiceOne(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
 
    @Override
    public void run() {
        System.out.println("Starting service One...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out
                .println("Service One has finished its work... waiting for others...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("Service one interrupted!");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Service one interrupted!");
            e.printStackTrace();
        }
        System.out.println("The wait is over, lets complete Service One!");
 
    }

}
