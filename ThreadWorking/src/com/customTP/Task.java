package com.customTP;

public class Task implements Runnable{
	
	int taskNum;
	
	public Task(int taskNum) {
		this.taskNum = taskNum;
	}
	
	@Override
	public void run() {
		System.out.println("Task No :" + taskNum + " running");
	}

}
