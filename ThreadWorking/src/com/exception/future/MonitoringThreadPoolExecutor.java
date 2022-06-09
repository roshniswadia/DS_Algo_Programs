package com.exception.future;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitoringThreadPoolExecutor extends ThreadPoolExecutor {
	
	public MonitoringThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
		      BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated constructor stub
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

	}
	
	@Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if(t != null){
            System.out.println("Exception message: " + t.getMessage());    
        }
    }

}
