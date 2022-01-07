package com.thread;

public class RunnableThread implements Runnable{
	private boolean flag=true;
	public void setFlag(boolean flag) {
		this.flag=flag;
	}
	public RunnableThread() {
		
	}
	long time;
	public RunnableThread(long time) {
		this.time=time;
	}
 	 public void run() {
		while(flag) {
		System.out.println("thread name:"+Thread.currentThread().getName());
		System.out.println("thread priority:"+Thread.currentThread().getPriority());
		System.out.println("thread state:"+Thread.currentThread().getState());
		System.out.println("Going to sleep:"+Thread.currentThread().getName());
		try {
	    Thread.sleep(time);
		}
		catch(InterruptedException e) {}
		System.out.println("after sleeping:"+Thread.currentThread().getName());
		}
	}

}
