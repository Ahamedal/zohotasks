package com.thread;
import java.util.*;
public class ThreadRunner {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int quesNo=0;
	try {
		System.out.println("enter quesno");
		quesNo=sc.nextInt();
		
		
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	switch(quesNo) {
	case 1:
		ExtendedThread thread1=new ExtendedThread();
		System.out.println("thread name:"+Thread.currentThread().getName());
		System.out.println("thread priority:"+Thread.currentThread().getPriority());
		System.out.println("thread state:"+Thread.currentThread().getState());
		thread1.start();
		break;
	case 2:
		RunnableThread runnable=new RunnableThread();
		Thread thread_1=new Thread(runnable);
		System.out.println("thread name:"+Thread.currentThread().getName());
		System.out.println("thread priority:"+Thread.currentThread().getPriority());
		System.out.println("thread state:"+Thread.currentThread().getState());
		thread_1.start();
		break;
	case 3:
		System.out.println("enter thread name");
		String tName=sc.nextLine();
		ExtendedThread exThread=new ExtendedThread();
		exThread.setName(tName);
		System.out.println("thread name:"+Thread.currentThread().getName());
		System.out.println("thread priority:"+Thread.currentThread().getPriority());
		System.out.println("thread state:"+Thread.currentThread().getState());
		exThread.start();
		
		RunnableThread runnable_1=new RunnableThread();
		Thread runThread=new Thread(runnable_1);
	    System.out.println("enter runnableName");
	    String runnableName=sc.nextLine();
	     runThread.setName(runnableName);
	    System.out.println("thread name:"+runThread.currentThread().getName());
	 	System.out.println("thread priority:"+runThread.currentThread().getPriority());
	 	System.out.println("thread state:"+runThread.currentThread().getState());
	     runThread.start();
	     break;
	case 4:
		//ExtendedThread tt=new ExtendedThread(6000);
		//tt.start();
		//RunnableThread r=new RunnableThread(4500);
		//Thread th1=new Thread(r);
		//th1.start();
		
		System.out.println("how many threads do you want");
		int size=sc.nextInt();
		sc.nextLine();
	
		for(int i=0;i<size;i++) {
			//System.out.println("enter name");
	String name=sc.nextLine();
	 ExtendedThread threadObj=new ExtendedThread(6000);
		threadObj.setName(name);
		threadObj.start();
		System.out.println("enter name");
		}
		System.out.println("how many runnablethreads do you want");
		int size1=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<size1;i++) {
			System.out.println("enter name");
	String name=sc.nextLine();
	RunnableThread objForRun=new RunnableThread(4500);
	Thread threadObj=new Thread(objForRun);
		threadObj.setName(name);
		threadObj.start();
		}
		break;
		

	    
	case 5:
		System.out.println("how many threads do you want");
		int size5=sc.nextInt();
		sc.nextLine();
	
		for(int i=0;i<size5;i++) {
			System.out.println("enter name");
	String name=sc.nextLine();
	System.out.println("enter time");
	long time=sc.nextLong();
	sc.nextLine();
	 ExtendedThread threadObj=new ExtendedThread(time);
		threadObj.setName(name);
		threadObj.start();
		}
		System.out.println("how many runnablethreads do you want");
		int size_5=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<size_5;i++) {
			System.out.println("enter name");
	String name=sc.nextLine();
	System.out.println("enter time");
	long time=sc.nextLong();
	sc.nextLine();
	RunnableThread objForRun=new RunnableThread(time);
	Thread threadObj=new Thread(objForRun);
		threadObj.setName(name);
		threadObj.start();
		}	
	break;	
	case 6:
		System.out.println("how many threads do you want");
		int size6=sc.nextInt();
		sc.nextLine();
		
		System.out.println("enter time");
		long time=sc.nextLong();
		
		for(int i=0;i<size6;i++) {
			
 ExtendedThread threadObj=new ExtendedThread(time);
		threadObj.setName("extended thread"+i);
		threadObj.start();
		RunnableThread objForRun6=new RunnableThread(time);
		Thread threadObj6=new Thread(objForRun6);
			threadObj6.setName("runnable thread"+i);
			threadObj6.start();
		}
		break;
	case 7:
		System.out.println("how many threads do you want");
		int size7=sc.nextInt();
		sc.nextLine();
		System.out.println("enter time");
		long time7=sc.nextLong();
		
		ExtendedThread[] extendedArray=new ExtendedThread[size7];
		RunnableThread[] runnableArray=new RunnableThread[size7];
		Thread[] threadArray=new Thread[size7];
		
		for(int i=0;i<size7;i++) {
			
        extendedArray[i]=new ExtendedThread(time7);
		extendedArray[i].setName("extended thread"+i);
		extendedArray[i].start();
		try {
		Thread.sleep(10000);
		}
		catch(Exception e) {}
		runnableArray[i]=new RunnableThread(time7);
		threadArray[i]=new Thread(runnableArray[i]);
			threadArray[i].setName("runnable thread"+i);
			threadArray[i].start();
			
		}
		for(int i=0;i<size7;i++) {
			extendedArray[i].setFlag(false);
			try {
			Thread.sleep(10000);
			System.out.println("stop"+"\n");
			}
			catch(Exception e) {}
			runnableArray[i].setFlag(false);
			try {
			Thread.sleep(10000);
			System.out.println("stop");
			}
			catch(Exception e) {}
			}
		System.out.println("task completed");
     break;
	}
}
}
